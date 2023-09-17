package com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.controller.rest;

import com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.dto.SymbolsDto;
import com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.service.FrequencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = {"/", "/{symbols}"})
    public Map<Character, Integer> getSymbols(@PathVariable(required = false) String symbols) {
        if (symbols == null) {
            return null;
        } else {
            return frequencyService.calculatingTheFrequency(symbols);
        }
    }

    @PostMapping
    public Map<Character, Integer> getSymbolsDto(@RequestBody(required = false) SymbolsDto symbolsDto) {
        if (symbolsDto == null) {
            return null;
        } else {
            return frequencyService.calculatingTheFrequency(symbolsDto.getSymbols());
        }
    }
}
