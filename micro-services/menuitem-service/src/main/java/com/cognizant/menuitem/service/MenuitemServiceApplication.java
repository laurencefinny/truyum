package com.cognizant.menuitem.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@EnableDiscoveryClient
public class MenuitemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuitemServiceApplication.class, args);
	}

}
