package com.cg.otms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//it is a combination of @configuration, @componentscan, @enableautoconfiguration

//it will configure the bean class, starts component scan from base package and auto configures the dispacther servlet 
//tomcat embbeded with ready to serve beans
public class OnlineTestManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineTestManagementApplication.class, args);
		// this will run or starts the application
	}
}
