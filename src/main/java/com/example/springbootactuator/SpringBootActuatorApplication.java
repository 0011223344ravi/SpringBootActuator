package com.example.springbootactuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootActuatorApplication {


	@GetMapping("/test/{name}")
	public String getName(@PathVariable String name){

		Logger logger = LoggerFactory.getLogger(SpringBootActuatorApplication.class);
		logger.error("Hello  " +name);
		return "Hello Ravi"+name;
	}




	public static void main(String[] args) {

		SpringApplication.run(SpringBootActuatorApplication.class, args);

	}

}
