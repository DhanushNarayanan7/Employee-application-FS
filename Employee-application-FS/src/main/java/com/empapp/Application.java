package com.empapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@PropertySource({"classpath:application.properties", "classpath:message.properties"})
public class Application {

	private static final Class<Application> applicationClass = Application.class;
	
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
		log.info("Employee Application started successfully... ");
	}

}
	