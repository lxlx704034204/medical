package com.bben.webservice.controller;

import com.alibaba.fastjson.JSON;
import com.bben.webservice.model.webservice.TControlParam;
import com.bben.webservice.vo.TControlParamVo;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.ArrayList;
import java.util.List;

public class WebserviceClient {

    public static void main(String[] args) {
        //testSend1();
        testSend2();
        testSend3();
    }

    static void testSend1() {

        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8200/services/WebServiceInterface?wsdl");

        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        Object[] objects = new Object[0];
        try {

            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sendMessage", "wyj");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    static void testSend2() {

        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8200/services/WebServiceInterface?wsdl");

        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        Object[] objects;
        try {

            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("findControlParam", "infusion_end_warn");
            TControlParam tControlParam = JSON.parseObject(JSON.toJSONString(objects[0]),TControlParam.class);
            System.out.println("testSend2=====>"+tControlParam.getCode());
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }


    static void testSend3() {

        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8200/services/WebServiceInterface?wsdl");

        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        Object[] objects;
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("findControlParamByCondition", null,"输液结束值","95");
            List<TControlParam> tControlParamArrayList= (ArrayList<TControlParam>)objects[0];
            List<TControlParamVo> tControlParamVoList = TControlParamVo.assemblyDataList(tControlParamArrayList);
            for (TControlParamVo tControlParamVo : tControlParamVoList) {
                System.out.println("testSend3返回数据:" + tControlParamVo.getCode());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
