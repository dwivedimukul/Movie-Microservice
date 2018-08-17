package com.stackroute.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieServiceApplication {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext context = SpringApplication.run(MovieServiceApplication.class, args);
	}
}
