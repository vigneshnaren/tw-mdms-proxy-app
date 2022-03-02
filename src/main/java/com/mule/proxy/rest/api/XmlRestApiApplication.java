package com.mule.proxy.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication

public class XmlRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlRestApiApplication.class, args);
	}

}
