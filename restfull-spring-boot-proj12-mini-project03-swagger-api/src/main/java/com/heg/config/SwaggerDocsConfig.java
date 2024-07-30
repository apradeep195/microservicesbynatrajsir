package com.heg.config;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {

	@Bean
	public Docket createDocket() {		
		return new Docket(DocumentationType.SWAGGER_2)
				.select() //To specify restController
				.apis(RequestHandlerSelectors.basePackage("com.heg.controller")) //base package of rest controller
				.paths(PathSelectors.regex("/tourist.*")) //to specify request path
				.build() //builds the docket object
				.useDefaultResponseMessages(true)
				.apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
		Contact contact= new Contact("raja", "http://www.hegltd.com", "hrdmdp@lnjbhilwara.com");
		return new ApiInfo("Tourist Api", "Give Tourist Info", "3.4 realesed", "http://www.hegltd/license", contact, "GNU public license", "http://apache.org.licenxe/gnu",Collections.emptyList());
	}
}
