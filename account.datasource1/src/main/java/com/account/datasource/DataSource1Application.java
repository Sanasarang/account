package com.account.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DataSource1Application {

	public static void main(String[] args) {
		SpringApplication.run(DataSource1Application.class, args);
	}

}
