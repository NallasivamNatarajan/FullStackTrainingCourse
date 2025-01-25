package com.cattle.management.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CattleManagementSwaggerConfig {
	
    @Bean
    Docket cattleApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Cattle Management")
                .apiInfo(apiCattleInfo()).select()
                .paths(regex("/cattle.*"))
                .build();
    }

	private ApiInfo apiCattleInfo() {
		return new ApiInfoBuilder().title("Cattle Management Service")
				.description("Sample Documentation Generated using Swagger2 for Cattle Management")
				.build();
	}
}
