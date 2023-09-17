package com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.controller.rest;

import com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.service.FrequencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest")
public class RequestRestController {

    public RequestRestController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    private final FrequencyService frequencyService;

    @GetMapping("/{symbols}")
    public Map<Character, Integer> getProductById(@PathVariable String symbols) {
        return frequencyService.calculatingTheFrequency(symbols);
    }

}
