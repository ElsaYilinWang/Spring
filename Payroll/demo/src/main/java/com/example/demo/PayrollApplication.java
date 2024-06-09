package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// @SpringBootApplication is a meta-annotation 
// that pulls in component scanning, auto-configuration, and property support.
public class PayrollApplication {

	public static void main(String... args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

}
