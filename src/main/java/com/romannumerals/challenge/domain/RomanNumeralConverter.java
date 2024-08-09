package com.romannumerals.challenge.domain;

import java.util.Map;
import java.util.TreeMap;

public class RomanNumeralConverter {
    private static final TreeMap<Integer, String> arabicToRomanMap = new TreeMap<>();
    private static final Map<String, Integer> romanToArabicMap = new TreeMap<>();

    static {
        arabicToRomanMap.put(1000, "M");
        arabicToRomanMap.put(500, "D");
        arabicToRomanMap.put(100, "C");
        arabicToRomanMap.put(50, "L");
        arabicToRomanMap.put(10, "X");
        arabicToRomanMap.put(5, "V");
        arabicToRomanMap.put(1, "I");

        // Invert the map to create the romanToArabicMap
        arabicToRomanMap.forEach((key, value) -> romanToArabicMap.put(value, key));
    }

}
