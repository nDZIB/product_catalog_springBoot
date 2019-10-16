package com.categoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class CategoryServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(CategoryServiceApp.class, args);
	}

	@Bean
	public Docket getDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}
