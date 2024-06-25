package com.elsa.springcoredemo.rest;

import com.elsa.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Qualifier;
// Qualifier for more specific beans

@RestController
public class DemoController {

    // define a private fie;d for teh dependency
    private Coach myCoach;

    // define a constructor for dependency
    @Autowired
    //public DemoController(@Qualifier("cricketCoach") Coach theCoach)
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    // Setter injection
    //@Autowired
    //public void setCoach(Coach theCoach){
    //    myCoach = theCoach;
    //}

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
