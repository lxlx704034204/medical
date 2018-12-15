package com.bben.webservice.webservice;

import com.bben.webservice.model.webservice.TControlParam;

import javax.jws.WebMethod;
import java.util.List;

/**
 * @author BBEN_LI
 */
@javax.jws.WebService
public interface WebServiceInterface {
    @WebMethod
    String sendMessage(String username);

    @WebMethod
    TControlParam findControlParam(String code);

    @WebMethod
    List<TControlParam> findControlParamByCondition(String code,String name,String value);
}