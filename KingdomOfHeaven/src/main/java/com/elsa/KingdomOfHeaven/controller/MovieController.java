package com.elsa.KingdomOfHeaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    // controller to show home page
    @RequestMapping("/home")
    public String showHome(){
        return "index";
    }

    // controller to show history page
    @RequestMapping("/history")
    public String showHistory(){
        return "history";
    }

    // controller to show characters page
    @RequestMapping("/characters")
    public String showCharacters(){
        return "characters";
    }

    // controller to show plots page
    @RequestMapping("/plots")
    public String showPlots(){
        return "plots";
    }

    // controller to show report page
    @RequestMapping("/report")
    public String showReport(){
        return "report";
    }



}
