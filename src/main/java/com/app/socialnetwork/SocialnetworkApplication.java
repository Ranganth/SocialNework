package com.app.socialnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableSwagger2
//http://localhost:8080/project-api/v2/api-docs - all the end points information
//http://localhost:8080/swagger-ui
@SpringBootApplication
@ComponentScan
public class SocialnetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialnetworkApplication.class, args);
	}

}
