package com.romannumerals.challenge.domain;

import com.romannumerals.challenge.application.exception.RomanNumeralException;

public class ArabicNumeral {
    private final int value;

    public ArabicNumeral(int value) {
        if (value <= 0 || value >= 4000) {
            throw new RomanNumeralException("Número fuera del rango permitido (1-3999)");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
