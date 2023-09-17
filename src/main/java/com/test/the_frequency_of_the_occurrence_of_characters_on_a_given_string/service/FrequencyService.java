package com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FrequencyService {

    public Map <Character, Integer> calculatingTheFrequency(String symbols) {
        List<Character> list = symbols
                .chars()
                .mapToObj(c -> (char) c).toList();
        return list
                .stream()
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
    }

}
