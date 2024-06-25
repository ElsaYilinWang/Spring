package com.elsa.springcoredemo.rest;

import com.elsa.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Qualifier;
// Qualifier for more specific beans

@RestController
public class DemoController {


    // define a private fie;d for teh dependency
    private Coach myCoach;
    private Coach anotherCoach;

    // define a constructor for dependency
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach ) {
            //@Qualifier("cricketCoach") Coach theAnotherCoach

        System.out.println("In constructor: " + getClass().getSimpleName());

        myCoach = theCoach;
        //anotherCoach = theAnotherCoach;
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

    // test Bean Scopes
    //@GetMapping("/check")
    //public String check(){
    //    return "Compare beans: my Coach == anotherCoach, " + (myCoach == anotherCoach);
    //}

}
