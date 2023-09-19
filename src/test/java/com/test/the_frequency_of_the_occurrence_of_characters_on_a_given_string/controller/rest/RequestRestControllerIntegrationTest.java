package com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.controller.rest;

import com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.dto.SymbolsDto;
import com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.service.FrequencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RequestRestControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private FrequencyService frequencyService;
    private final SymbolsDto symbolsDto = new SymbolsDto();
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<SymbolsDto> requestEntity;
    private final Map<Character, Integer> map = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {
        symbolsDto.setSymbols("12345");
        headers.setContentType(MediaType.APPLICATION_JSON);
        requestEntity = new HttpEntity<>(symbolsDto, headers);
        map.put('1', 1);
        map.put('2', 1);
        map.put('3', 1);
        map.put('4', 1);
        map.put('5', 1);

    }

    @Test
    void getSymbols() {
        ResponseEntity<Map> entity = restTemplate.getForEntity("/rest/12345", Map.class);
        assertSame(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(Objects.requireNonNull(entity.getBody()).toString(), map.toString());
    }

    @Test
    void getSymbolsDto(){
        ResponseEntity<Map> entity = restTemplate.postForEntity("/rest", requestEntity, Map.class);
        assertSame(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(Objects.requireNonNull(entity.getBody()).toString(), map.toString());
    }

}