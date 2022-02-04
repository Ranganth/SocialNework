package com.app.socialnetwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.app.socialnetwork"))
	.paths(PathSelectors.any())
	.build().apiInfo(metaData());
	}



	private ApiInfo metaData() {
	return new ApiInfoBuilder()
	.title("Social Network - Spring Boot Swagger Configuration")
	.description("\"Swagger configuration for application \"")
	.version("1.1.0")
	.license("Apache 2.0")
	.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
	.contact(new Contact("Social Network", null, null))
	.build();

}}
