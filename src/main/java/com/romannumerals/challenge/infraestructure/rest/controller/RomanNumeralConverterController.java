package com.romannumerals.challenge.infraestructure.rest.controller;

import com.romannumerals.challenge.application.service.usecase.RomanNumeralConverterUseCase;
import com.romannumerals.challenge.domain.ArabicNumeral;
import com.romannumerals.challenge.domain.RomanNumeral;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class RomanNumeralConverterController {
    private final RomanNumeralConverterUseCase converter;

    public RomanNumeralConverterController(RomanNumeralConverterUseCase converter) {
        this.converter = converter;
    }

    @GetMapping("/to-roman")
    public String convertToRoman(@RequestParam int number) {
        ArabicNumeral arabicNumeral = new ArabicNumeral(number);
        return converter.toRoman(arabicNumeral);
    }

    @GetMapping("/to-arabic")
    public int convertToArabic(@RequestParam String roman) {
        String romanUpperCase = roman.toUpperCase();
        RomanNumeral romanNumeral = new RomanNumeral(romanUpperCase);
        return converter.toArabic(romanNumeral);
    }
}
