package com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelpController {
    @GetMapping("/")
    public String Hello(){
        return "index.html";
    }
}
