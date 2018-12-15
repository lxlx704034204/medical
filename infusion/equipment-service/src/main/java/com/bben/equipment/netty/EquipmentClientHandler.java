package com.bben.equipment.netty;

import com.alibaba.fastjson.JSON;
import com.bben.equipment.config.RedisTemplateUtil;
import com.bben.equipment.mapper.TGatherDataMapper;
import com.bben.equipment.model.TGatherData;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


/**
 * @author chenxudong
 * @version 1.0
 * @date 2018年10月20日
 */
@Component
@ChannelHandler.Sharable
public class EquipmentClientHandler extends ChannelInboundHandlerAdapter {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final short FLAG_FA = 0xFA;     //FA值
    private static final short LEN_1A = 0x1A;     //1A值
    private static final short ONE_LEN = 28;     //28值

    private String host;
    private int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @Autowired
    private TGatherDataMapper tGatherDataMapper;//这里会报错，但是并不会影响

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        int total_len = buf.readableBytes();
        log.info("Recived data :" + ByteBufUtil.hexDump(buf).toUpperCase());

        //判断整个协议长度要大约等于28个字节
        if (total_len < ONE_LEN) {
            log.info("protocl length >=28,now length is " + total_len);
            return;
        }

        int sn_count = total_len / ONE_LEN; //一台设备有28个字节内容
        log.info("sn_count:" + sn_count);

        for (int count = 0; count < sn_count; count++) {
            //解析读出的协议
            short begin = buf.readUnsignedByte();
            if (begin != FLAG_FA) {
                log.info("protocl is not begin FA. now is " + begin);

                //丢弃该段协议的数据
                byte[] byt_t = new byte[27];
                buf.readBytes(byt_t);
                continue;
            }

            short len = buf.readUnsignedByte();
            if (len != LEN_1A) {
                log.info("protocl is not len = 1A. now is " + len);

                //丢弃该段协议的数据
                byte[] byt_t = new byte[26];
                buf.readBytes(byt_t);
                continue;
            }

            //数据校验码
            int checksum = 0;

            //buf里的数据：设备号
            byte[] byt_sn = new byte[14];
            for (int i = 0; i < 14; i++) {
                byte temp = buf.readByte();  //设备号 M010711M01SON1

                checksum += temp;
                byt_sn[i] = temp;
            }

            String sn = new String(byt_sn);

            byte spaceTemp = buf.readByte();   //空格 丢弃
            checksum += spaceTemp;

            byte[] byt_voltage = new byte[3];
            for (int i = 0; i < 3; i++) {
                byte temp = buf.readByte();  //电压
                checksum += temp;
                byt_voltage[i] = temp;  //电压
            }

            String voltage = new String(byt_voltage);

            byte temp2 = buf.readByte();   //+ 丢弃
            checksum += temp2;

            byte[] byt_weight = new byte[5];
            for (int i = 0; i < 5; i++) {
                byte temp = buf.readByte();  //重量

                checksum += temp;
                byt_weight[i] = temp;  //重量
            }

            String weight = new String(byt_weight);
            log.info("Str_sn=" + sn + " 电压=" + voltage + " 重量=" + weight);

            int tempI = buf.readUnsignedShort();
            if (checksum != tempI) {
                log.info("calculate checkSum=" + checksum + ", read checkSum=" + tempI);
                continue;
            }

            TGatherData gatherData = new TGatherData();
            try {
                gatherData.setVoltage(Integer.parseInt(voltage));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                gatherData.setWeight(Integer.parseInt(weight));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            gatherData.setCreateTime(new Date());
            gatherData.setEquipmentSn(sn);
            gatherData.setIp(host);
            gatherData.setPort(port);

            redisTemplateUtil.lList(sn, gatherData, 900);//十五分钟的保存时间

            tGatherDataMapper.insertSelective(gatherData);

//            List<Object> xx =  redisTemplateUtil.lGet(sn,0,-1);
//
//            for(Object x : xx) {
//                System.out.println("redis data:" + x.toString());
//                Equipment equipmentx = JSON.parseObject(x.toString(), Equipment.class);
//                System.out.println("Equipment Voltage data:" + equipmentx.getVoltage());
//            }
        }

        ReferenceCountUtil.release(msg);
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        closeOnFlush(ctx.channel());  // 发生异常，关闭链路
    }

    static void closeOnFlush(Channel ch) {
        if (ch.isActive()) {
            ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }
}
