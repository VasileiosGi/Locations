package com.exercise.springBootSoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.exercise.springBootSoap.service.LocationServiceImpl;

@SpringBootApplication
@EnableCaching
public class SpringBootSoapApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringBootSoapApplication.class, args);
    	
	}
	//mpou

}
