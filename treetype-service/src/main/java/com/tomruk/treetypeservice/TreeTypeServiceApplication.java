package com.tomruk.treetypeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TreeTypeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeTypeServiceApplication.class, args);
	}

}
