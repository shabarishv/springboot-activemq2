package com.volvo.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJmsApplication.class, args);
	}
}
