package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan(basePackages={"com.cognizant.truyum.controller","com.cognizant.truyum.service","com.cognizant.truyum.dao"})
public class TruyumApplication {

	public static void main(String[] args) {

		SpringApplication.run(TruyumApplication.class, args);

	}

}
