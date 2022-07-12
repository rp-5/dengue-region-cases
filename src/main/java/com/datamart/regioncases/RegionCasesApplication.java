package com.datamart.regioncases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegionCasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionCasesApplication.class, args);
	}

}
