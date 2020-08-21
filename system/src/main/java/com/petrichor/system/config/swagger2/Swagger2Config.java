package com.petrichor.system.config.swagger2;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: Swagger2Config
 * @Description: swagger2 配置文件
 * @Author: yongchen
 * @Date: 2020/7/30 17:06
 **/
@Configuration
@EnableSwagger2
@EnableKnife4j

public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.petrichor.system.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot ic-petrichor RESTful APIs")
                .description("Spring Boot ic-petrichor")
                .termsOfServiceUrl("http://localhost:8123/")
                .contact("developer@mail.com")
                .version("v1.0")
                .build();
    }
}
