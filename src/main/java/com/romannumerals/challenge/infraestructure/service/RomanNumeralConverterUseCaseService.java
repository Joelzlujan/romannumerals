package com.romannumerals.challenge.infraestructure.service;

import com.romannumerals.challenge.application.exception.RomanNumeralException;
import com.romannumerals.challenge.infraestructure.service.usecase.RomanNumeralConverterUseCase;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RomanNumeralConverterUseCaseService implements RomanNumeralConverterUseCase {
    private static final TreeMap<Integer, String> arabicToRomanMap = new TreeMap<>();
    private static final Map<String, Integer> romanToArabicMap = new TreeMap<>();

    static {
        arabicToRomanMap.put(1000, "M");
        arabicToRomanMap.put(900, "CM");
        arabicToRomanMap.put(500, "D");
        arabicToRomanMap.put(400, "CD");
        arabicToRomanMap.put(100, "C");
        arabicToRomanMap.put(90, "XC");
        arabicToRomanMap.put(50, "L");
        arabicToRomanMap.put(40, "XL");
        arabicToRomanMap.put(10, "X");
        arabicToRomanMap.put(9, "IX");
        arabicToRomanMap.put(5, "V");
        arabicToRomanMap.put(4, "IV");
        arabicToRomanMap.put(1, "I");

        arabicToRomanMap.forEach((key, value) -> romanToArabicMap.put(value, key));
    }

    @Override
    public String toRoman(int number) {
        if (number <= 0 || number >= 4000) {
            throw new RomanNumeralException("Número fuera del rango permitido (1-3999)");
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : arabicToRomanMap.descendingMap().entrySet()) {
            while (number >= entry.getKey()) {
                result.append(entry.getValue());
                number -= entry.getKey();
                System.out.println("number: " + number);
                System.out.println("entry.getKey(): " + entry.getKey());
                System.out.println("entry.getValue(): " + entry.getValue());
            }
        }
        return result.toString();
    }

    @Override
    public int toArabic(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new RomanNumeralException("El valor romano no puede estar vacío");
        }
        if (!roman.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            throw new RomanNumeralException("Formato romano inválido");
        }
        int result = 0;
        int previousValue = 0;
        for (int i = 0; i < roman.length(); i++) {
            String currentSymbol = roman.substring(i, i + 1);
            int currentValue = romanToArabicMap.get(currentSymbol);

            if (currentValue == 0) {
                throw new RomanNumeralException("Valor romano inválido");
            }

            if (currentValue > previousValue) {
                result += currentValue - 2 * previousValue;
            } else {
                result += currentValue;
            }
            previousValue = currentValue;
        }

        return result;
    }

}
