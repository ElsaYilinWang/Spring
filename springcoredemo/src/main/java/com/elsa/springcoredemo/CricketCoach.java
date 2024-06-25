package com.elsa.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach extends Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }
}
