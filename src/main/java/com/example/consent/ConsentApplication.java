package com.example.consent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConsentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsentApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/v1/consent").allowedOrigins("http://localhost:3000");
				registry.addMapping("/v1/consent/set").allowedOrigins("http://localhost:3000");
			}
		};
	}

}
