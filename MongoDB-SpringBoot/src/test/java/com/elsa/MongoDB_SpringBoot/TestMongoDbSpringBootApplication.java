package com.elsa.MongoDB_SpringBoot;

import org.springframework.boot.SpringApplication;

public class TestMongoDbSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.from(MongoDbSpringBootApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
