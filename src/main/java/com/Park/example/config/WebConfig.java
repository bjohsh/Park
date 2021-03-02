package com.Park.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {	
	   @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	            .allowedOrigins("*") // vue �꽌踰꾩쓽 �룄硫붿씤, �룷�듃濡� �닔�젙
	            .allowedMethods("*")
	        	.exposedHeaders("jwt-token");
	    }


}

