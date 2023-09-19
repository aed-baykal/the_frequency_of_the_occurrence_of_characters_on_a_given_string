package com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.controller.rest;

import com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.dto.SymbolsDto;
import com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.service.FrequencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class RequestRestControllerTest {

    @Autowired
    private FrequencyService frequencyService;
    private RequestRestController requestRestController;
    private final SymbolsDto symbolsDto = new SymbolsDto();
    private final Map<Character, Integer> map = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {
        FrequencyService frequencyService = mock(FrequencyService.class);
        when(frequencyService.calculatingTheFrequency("12345")).thenReturn(map);
        requestRestController = new RequestRestController(frequencyService);
    }

    @Test
    void getSymbolDto() {
        symbolsDto.setSymbols("12345");
        Map<Character, Integer> currentMap = requestRestController.getSymbolsDto(symbolsDto);
        map.put('1', 1);
        map.put('2', 1);
        map.put('3', 1);
        map.put('4', 1);
        map.put('5', 1);
        assertEquals(currentMap, map);
    }
}