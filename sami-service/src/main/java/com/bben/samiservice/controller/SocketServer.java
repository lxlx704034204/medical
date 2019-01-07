package com.bben.samiservice.controller;


import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.bben.samiservice.Dto.DeptDto;
import com.bben.samiservice.Dto.DoctorDto;
import com.bben.samiservice.Dto.NurseDto;
import com.bben.samiservice.constants.EmployeeType;
import com.bben.samiservice.constants.MessageType;
import com.bben.samiservice.constants.ReturnMessage;
import com.bben.samiservice.converter.HL7ToXmlConverter;
import com.bben.samiservice.model.samiservice.TDept;
import com.bben.samiservice.model.samiservice.TDoctor;
import com.bben.samiservice.model.samiservice.TNurse;
import com.bben.samiservice.service.TDeptService;
import com.bben.samiservice.service.TDoctorService;
import com.bben.samiservice.service.TNurseService;
import com.bben.samiservice.util.SaMiMethodUtil;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * nio socket服务端
 */
@Component
public class SocketServer extends BaseController {

    @Autowired
    private TDeptService tDeptService;

    @Autowired
    private TDoctorService tDoctorService;

    @Autowired
    private TNurseService tNurseService;

    private static SocketServer  socketServer;

    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {
        socketServer = this;
        socketServer.tDeptService = this.tDeptService;
        socketServer.tDoctorService = this.tDoctorService;
        socketServer.tNurseService = this.tNurseService;
        // 初使化时将已静态化的testService实例化
    }

    @Autowired
    RestTemplate restTemplate;

    //解码buffer
    private Charset cs = Charset.forName("GBK");
    //接受数据缓冲区
    private static ByteBuffer sBuffer = ByteBuffer.allocate(1024);
    //发送数据缓冲区
    private static ByteBuffer rBuffer = ByteBuffer.allocate(1024);
    //选择器（叫监听器更准确些吧应该）
    private static Selector selector;

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 启动socket服务，开启监听
     *
     * @param port
     * @throws IOException
     */
    public void startSocketServer(int port) {
        try {
            //打开通信信道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //获取套接字
            ServerSocket serverSocket = serverSocketChannel.socket();
            //绑定端口号
            serverSocket.bind(new InetSocketAddress(port));
            //打开监听器
            selector = Selector.open();
            //将通信信道注册到监听器
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //监听器会一直监听，如果客户端有请求就会进入相应的事件处理
            while (true) {
                selector.select();//select方法会一直阻塞直到有相关事件发生或超时
                Set<SelectionKey> selectionKeys = selector.selectedKeys();//监听到的事件
                for (SelectionKey key : selectionKeys) {
                    handle(key);
                }
                selectionKeys.clear();//清除处理过的事件
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 处理不同的事件
     *
     * @param selectionKey
     * @throws IOException
     */
    private void handle(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel socketChannel = null;
        String requestMsg = "";
        int count = 0;
        String result = "";
        String url = "http://sami-service";
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();

        try {
            if (selectionKey.isAcceptable()) {
                //每有客户端连接，即注册通信信道为可读
                serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            } else if (selectionKey.isReadable()) {
                socketChannel = (SocketChannel) selectionKey.channel();
                rBuffer.clear();
                count = socketChannel.read(rBuffer);
                //读取数据
                if (count > 0) {
                    rBuffer.flip();
                    requestMsg = String.valueOf(cs.decode(rBuffer).array()).trim();
                }
                //requestMsg = requestMsg.substring(1,requestMsg.length()-16);
                String responseMsg = "已收到客户端的消息:" + requestMsg;
                requestMsg = requestMsg.replaceAll("\r","\n");
                System.out.println(responseMsg);
                String requestMsgXml = HL7ToXmlConverter.ConvertToXml(requestMsg);
                System.out.println("========="+requestMsgXml);
                //requestMsg = new String(requestMsg.getBytes("gbk"),"utf-8");
                Document document = HL7ToXmlConverter.ConvertToXmlObject(requestMsg);
                String nodeValue = document.selectSingleNode("HL7Message/MSH/MSH.9/MSH.9.1").getText();
                String nodeValue1 = document.selectSingleNode("HL7Message/MSH/MSH.9/MSH.9.2").getText();
                //DeptController deptController = new DeptController();
                //Result result1 = deptController.selectAll();
                result = dept(requestMsg).toString();
                if (nodeValue.equals(MessageType.MFN)&& nodeValue1.equals(MessageType.M01)){
                    String value = document.selectSingleNode("HL7Message/MFI/MFI.1/MFI.1.1").getText();
                    if (value.equals(MessageType.DEPARTMENT)){
                        /**
                         * 推送内容为科室信息
                         */
                        result = dept(requestMsg).toString();
                    }else if (value.equals(MessageType.EMPLOYEE)){
                        String type = HL7ToXmlConverter.GetText(document, "Z02/Z02.11");
                        if (U.isBlank(type)){
                            throw new RuntimeException();
                        }
                        switch (type){
                            case EmployeeType.N:
                                result = employeeForNurse(requestMsg).toString();
                                break;
                            case EmployeeType.D:
                                result = employeeForDoctor(requestMsg).toString();
                                break;
                            default:throw new RuntimeException();
                        }

                    }
                }
        }
        }catch (Exception e){
            e.printStackTrace();
            result = "处理异常";
        }finally {
            sBuffer = ByteBuffer.allocate(result.getBytes("GBK").length);
            sBuffer.put(result.getBytes("GBK"));
            sBuffer.flip();
            socketChannel.write(sBuffer);
            System.out.println(sBuffer);
            //System.out.println("解析的xml为:"+HL7ToXmlConverter.ConvertToXml(requestMsg));
            //返回数据
            /*sBuffer = ByteBuffer.allocate(responseMsg.getBytes("GBK").length);
            sBuffer.put(responseMsg.getBytes("GBK"));
            sBuffer.flip();
            socketChannel.write(sBuffer);*/
            //socketChannel.close();
        }
    }

    /**
     * 科室信息
     * @param message
     * @return
     */
    public Result dept(String message){
        if (U.isBlank(message)){
            return Result.fail(ReturnMessage.MESSAGE_IS_NULL);
        }
        Document document = HL7ToXmlConverter.ConvertToXmlObject(message);
        DeptDto deptDto = new DeptDto();
        deptDto.setCode(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.1")));
        deptDto.setName(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.2")));
        deptDto.setEname(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.3")));
        deptDto.setSimpleName(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.4")));
        deptDto.setType(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.5")));
        deptDto.setRegdeptFlag(SaMiMethodUtil.byteVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.6")));
        deptDto.setTatdeptFlag(SaMiMethodUtil.byteVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.7")));
        deptDto.setDeptPro(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.8")));
        deptDto.setStatus(SaMiMethodUtil.byteVal(HL7ToXmlConverter.GetText(document, "Z01/Z01.9")));
        TDept tDept = socketServer.tDeptService.operationDept(DeptDto.assemblyData(deptDto));
        if (U.isBlank(tDept)){
            return Result.fail(ReturnMessage.ERROR);
        }
        return Result.success(ReturnMessage.SUCCECSS);
    }

    /**
     * 医生信息
     * @param message
     * @return
     */
    public Result employeeForDoctor(String message){
        if (U.isBlank(message)){
            return Result.fail(ReturnMessage.MESSAGE_IS_NULL);
        }
        Document document = HL7ToXmlConverter.ConvertToXmlObject(message);
        String deptCode = HL7ToXmlConverter.GetText(document, "Z02/Z02.9/Z02.9.1");
        String nurseCellCode = HL7ToXmlConverter.GetText(document, "Z02/Z02.10");
        Integer nurseCode = 0;

        if (U.isBlank(deptCode)){
            return null;
        }
        TDept tDept = socketServer.tDeptService.selectByCode(deptCode);
        if (U.isBlank(tDept)){
            log.info("没有科室信息...");
            return null;
        }
        if (U.isNotBlank(nurseCellCode)){
            TDept tDept1= socketServer.tDeptService.selectByCode(nurseCellCode);
            if (U.isNotBlank(tDept1)){
                nurseCode = tDept1.getId();
            }
        }
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setCode(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.1")));
        doctorDto.setDoctorName(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.2")));
        doctorDto.setSex(SaMiMethodUtil.chooseSex(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.3"))));
        doctorDto.setBirthday(SaMiMethodUtil.dateFormat(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.4"))));
        doctorDto.setDuties(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.5")));
        doctorDto.setTitle(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.6")));
        doctorDto.setEducation(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.7")));
        doctorDto.setIdNumber(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.8")));
        //doctorDto.setHospitalDeptId(tDept.getId());
        doctorDto.setHospitalDeptId(1);
        doctorDto.setNurseCellCode(Integer.valueOf(nurseCode));
        doctorDto.setIsExpert(SaMiMethodUtil.byteVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.12")));
        doctorDto.setStatus(SaMiMethodUtil.byteVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.13")));
        TDoctor tDoctor = socketServer.tDoctorService.operationDoctor(DoctorDto.assemblyData(doctorDto));
        if (U.isBlank(tDoctor)){
            return Result.fail(ReturnMessage.ERROR);
        }
        return Result.success(ReturnMessage.SUCCECSS);
    }

    /**
     * 护士信息
     * @param message
     * @return
     */
    public Result employeeForNurse(String message){
        if (U.isBlank(message)){
            return Result.fail(ReturnMessage.MESSAGE_IS_NULL);
        }
        Document document = HL7ToXmlConverter.ConvertToXmlObject(message);
        String deptCode = HL7ToXmlConverter.GetText(document, "Z02/Z02.9/Z02.9.1");
        String nurseCellCode = HL7ToXmlConverter.GetText(document, "Z02/Z02.10");
        Integer nurseCode = 0;
        if (U.isBlank(deptCode)){
            return null;
        }
        TDept tDept = socketServer.tDeptService.selectByCode(deptCode);
        if (U.isBlank(tDept)){
            log.info("没有科室信息...");
            return null;
        }
        if (U.isNotBlank(nurseCellCode)){
            TDept tDept1= socketServer.tDeptService.selectByCode(nurseCellCode);
            if (U.isNotBlank(tDept1)){
                nurseCode = tDept1.getId();
            }
        }
        NurseDto nurseDto = new NurseDto();
        nurseDto.setCode(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.1")));
        nurseDto.setName(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.2")));
        nurseDto.setSex(SaMiMethodUtil.chooseSex(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.3"))));
        nurseDto.setBirthday(SaMiMethodUtil.dateFormat(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.4"))));
        nurseDto.setDuties(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.5")));
        nurseDto.setTitle(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.6")));
        nurseDto.setEducation(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.7")));
        nurseDto.setIdNumber(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.8")));
        nurseDto.setHospitalDeptId(tDept.getId());
        nurseDto.setHospitalDeptId(1);
        nurseDto.setNurseCellCode(Integer.valueOf(nurseCode));
        nurseDto.setStatus(SaMiMethodUtil.byteVal(HL7ToXmlConverter.GetText(document, "Z02/Z02.13")));
        TNurse tNurse = socketServer.tNurseService.operationNurse(NurseDto.assemblyData(nurseDto));
        if (U.isBlank(tNurse)){
            return Result.fail(ReturnMessage.ERROR);
        }
        return Result.success(ReturnMessage.SUCCECSS);
    }


}