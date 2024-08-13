package com.romannumerals.challenge.application.service.usecase;

import com.romannumerals.challenge.domain.ArabicNumeral;
import com.romannumerals.challenge.domain.RomanNumeral;

public interface RomanNumeralConverterUseCase {
    String toRoman(ArabicNumeral arabicNumeral);

    int toArabic(RomanNumeral romanNumeral);
}
