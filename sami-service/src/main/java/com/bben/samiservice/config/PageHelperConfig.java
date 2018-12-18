package com.bben.samiservice.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Properties;

/**
 * 分页插件的配置,支持mysql，sql server 分页
 */
@Configuration
public class PageHelperConfig {
//    @Value("${pagehelper.helperDialect}")
//    private String helperDialect;

    @Bean(name = "pageInterceptorMysql")
    @Primary
    public PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments","true");
//        properties.setProperty("offsetAsPageNum", "true");
//        properties.setProperty("rowBoundsWithCount", "true");

        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    @Bean(name="pageInterceptorSqlServer")
    public PageInterceptor pageInterceptorSqlServer(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "sqlserver");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    @Bean(name="pageInterceptorOracle")
    public PageInterceptor pageInterceptorOracle(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "oracle");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
