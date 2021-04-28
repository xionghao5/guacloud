package com.gua.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class GuaeurakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuaeurakeApplication.class, args);
	}

}
