package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@EnableFeignClients("com.cognizant")
@SpringBootApplication
public class HospitalWebPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalWebPortalApplication.class, args);
	}

}
