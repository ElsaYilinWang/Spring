package com.elsa.springcoredemo.config;

import com.elsa.springcoredemo.common.Coach;
import com.elsa.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }


}
