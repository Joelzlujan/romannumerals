package com.romannumerals.challenge.infraestructure.service;

import com.romannumerals.challenge.domain.RomanNumeralConverter;
import org.springframework.stereotype.Service;

@Service
public class RomanNumeralService {
    private final RomanNumeralConverter converter = new RomanNumeralConverter();

    public String convertToRoman(int number) {
        return converter.toRoman(number);
    }

    public int convertToArabic(String roman) {
        return converter.toArabic(roman);
    }
}
