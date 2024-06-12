package com.example.demo;

// We preload that it has data
// The following class gets loaded automatically by Spring

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase{

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository,//
                OrderRepository orderRepository){

        return args -> {
            // Update employee repository and order repository
            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "thief"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));


            orderRepository.findAll().forEach( //
                order -> {log.info("Preloading " + order);}
                );
            
        };
    }
}

// What happens when it gets loaded?
// - Spring Boot runs ALL CommandLineRunner beans once the application context is loaded.
// - This runner requests a copy of the EmployeeRepository you just created.
// - The runner creates two entities and stores them.

