package com.romannumerals.challenge.infraestructure.service.usecase;

public interface RomanNumeralConverterUseCase {
    String toRoman(int number);
    int toArabic(String roman);
}
