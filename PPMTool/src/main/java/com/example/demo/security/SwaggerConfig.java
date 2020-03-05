package com.example.demo.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * 1) add swagger dependancies 
 * 2) create thsi class 
 * 3) enable url in securityconfiguration
 * 
 * */




@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
/*				.apiInfo(metadata())
				 .useDefaultResponseMessages(false)//
		        .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))//
		        .tags(new Tag("users", "Operations about users"))//
		        .tags(new Tag("ping", "Just a ping"))//
		        .genericModelSubstitutes(Optional.class);
*/				 
	}
	
	 private ApiInfo metadata() {
		    return new ApiInfoBuilder()//
		        .title("JSON Web Token Authentication API")//
		        .description("")//
		        .version("1.0.0")//
		        .license("").licenseUrl("")//
		        .contact(new Contact(null, null, "dummy@gamil.com"))//
		        .build();
		  }		

}
