package com.wildcodeschool.oqsecuritychallenge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuController {
    
    @GetMapping("/")
    public String forEveryone() {
        return  "Welcome to the SHIELD";
    }

    @GetMapping("/avengers/assemble")
    public String forTheAgents() {
        return "Avengers... Assemble";
    }

    @GetMapping("/secret-bases")
    public String forTheDirlo() {
        return "ils ont mis un lien mort mdr...";
    }
}
