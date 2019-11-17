package com.mbc.hr.recruitment.api;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HrSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrSystemApiApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.mbc"))
				.build()
				.apiInfo(apiDetails());
		
	}
	
	private ApiInfo apiDetails()
	{
		return  new ApiInfo("small HR system API", 
				"API tutorial for user describe how to operate recruitment technical process", 
				"0.1",
				"Free to use",
				new springfox.documentation.service.Contact("Alaa", "http://mbc.com", "AA@cc.com"), 
				"API Licence",
				"http://mbc.com",
				Collections.emptyList());
	}

}
