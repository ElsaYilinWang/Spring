package com.elsa.MongoDB_SpringBoot;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class MongoDbSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbSpringBootApplication.class, args);
	}

}
