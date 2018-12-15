package com.bben.common.interceptor;

//import com.xyb.common.entity.po.BasePo;
//import com.xyb.common.util.UserContextHolder;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.ibatis.executor.parameter.ParameterHandler;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
//import org.springframework.stereotype.Component;
//
//import java.sql.PreparedStatement;
//import java.util.Date;
//import java.util.Properties;
//
//@Component
//@Intercepts({
//        @Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class})
//})
public class AuditInterceptor { //implements Interceptor {

//    private final static String DEFAULT_USERNAME = "system";
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        DefaultParameterHandler statementHandler = (DefaultParameterHandler) invocation.getTarget();
//        if (statementHandler.getParameterObject() instanceof BasePo) {
//            BasePo parameter = (BasePo) statementHandler.getParameterObject();
//            String username = StringUtils.defaultIfBlank(UserContextHolder.getInstance().getUsername(), DEFAULT_USERNAME);
//            parameter.setCreatedBy(username);
//            parameter.setCreatedTime(new Date());
//            parameter.setUpdatedBy(username);
//            parameter.setUpdatedTime(new Date());
//        }
//        return invocation.proceed();
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//    }

}
