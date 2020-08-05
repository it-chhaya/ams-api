package com.chhaya.amsapi.configuration;

import com.chhaya.amsapi.constant.ApiConstants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {
    
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info()
            .title("DGB AMS API")
            .version(ApiConstants.API_VERSION)
            .description("Article Management System - API Documentation")
            .termsOfService("http://swagger.io/terms/")
            .license(new License().name("Apache 2.0").url("http://springdoc.org"))
        );
    }

}