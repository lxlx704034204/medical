package com.bben.webservice.webservice.impl;

import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.webservice.mapper.webservice.TControlParamMapper;
import com.bben.webservice.model.webservice.TControlParam;
import com.bben.webservice.model.webservice.TControlParamExample;
import com.bben.webservice.webservice.WebServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@javax.jws.WebService(//serviceName = "WebService",//对外发布的服务名
        targetNamespace = "http://webservice.webservice.bben.com/", endpointInterface = "com.bben.webservice.webservice.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface {

    @Autowired
    private TControlParamMapper tControlParamMapper;

    @Override
    public String sendMessage(String username) {
        System.out.println("我是webservice服务");
        return "hello " + username;
    }

    @Override
    public TControlParam findControlParam(String code) {
        if (U.isBlank(code)){
            return null;
        }
        TControlParam tControlParam =  tControlParamMapper.selectByPrimaryKey(code);
        if (U.isBlank(tControlParam)){
            return null;
        }
        return tControlParam;
    }

    @Override
    public List<TControlParam> findControlParamByCondition(String code, String name,String value) {
        TControlParamExample tControlParamExample = new TControlParamExample();
        TControlParamExample.Criteria criteria = tControlParamExample.createCriteria();
        if (U.isNotBlank(code)){
            criteria.andCodeEqualTo(code);
        }
        if (U.isNotBlank(name)){
            criteria.andNameEqualTo(name);
        }
        if (U.isNotBlank(value)){
            criteria.andValueEqualTo(value);
        }
        List<TControlParam> tControlParamList = tControlParamMapper.selectByExample(tControlParamExample);
        if (A.isEmpty(tControlParamList)){
            return null;
        }
        return tControlParamList;
    }
}
