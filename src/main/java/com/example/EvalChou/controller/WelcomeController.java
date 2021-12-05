package com.example.EvalChou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomeController {
    @GetMapping
    public String getwelcom(){

        return "You are welcome GET" ;
    }
    @PostMapping
    public String postwelcom(){


        return "You are welcome POST";
    }
}
