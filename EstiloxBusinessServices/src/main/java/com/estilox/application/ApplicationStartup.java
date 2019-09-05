package com.estilox.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Kamesh
 **/
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class ApplicationStartup{
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStartup.class, args);
	}
}