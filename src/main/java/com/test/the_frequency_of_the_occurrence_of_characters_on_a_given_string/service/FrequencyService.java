package com.test.the_frequency_of_the_occurrence_of_characters_on_a_given_string.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
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
        Map <Character, Integer> map = list
                .stream()
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        return map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)
                );
    }

}
