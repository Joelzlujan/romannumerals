package com.romannumerals.challenge.domain;

import com.romannumerals.challenge.application.exception.RomanNumeralException;

public class RomanNumeral {
    private final String value;

    public RomanNumeral(String value) {
        if (value == null || value.isEmpty()) {
            throw new RomanNumeralException("El valor romano no puede estar vacío");
        }
        if (!value.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            throw new RomanNumeralException("Formato romano inválido");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
