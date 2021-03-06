package com.bben.infusion.config;

//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ConditionalOnClass({Docket.class, ApiInfo.class, EnableSwagger2.class})
@Configuration
public class Swagger2 {
    @Value("${online:false}")
    private boolean online;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(!online).useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bben.infusion.controller"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("博本智慧医疗接口文档")
                .description("Spring Boot中使用Swagger2构建RESTful APIs")
                .termsOfServiceUrl("http://www.bben.com/index.html")
                .version("1.0").build();
    }
}
