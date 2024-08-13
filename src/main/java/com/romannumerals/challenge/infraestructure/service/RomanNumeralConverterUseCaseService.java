package com.romannumerals.challenge.infraestructure.service;

import com.romannumerals.challenge.domain.ArabicNumeral;
import com.romannumerals.challenge.domain.RomanNumeral;
import com.romannumerals.challenge.infraestructure.service.usecase.RomanNumeralConverterUseCase;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RomanNumeralConverterUseCaseService implements RomanNumeralConverterUseCase {
    private static final TreeMap<Integer, String> arabicToRomanMap = new TreeMap<>();
    private static final Map<String, Integer> romanToArabicMap = new HashMap<>();

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
    public String toRoman(ArabicNumeral arabicNumeral) {
        int number = arabicNumeral.getValue();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : arabicToRomanMap.descendingMap().entrySet()) {
            while (number >= entry.getKey()) {
                result.append(entry.getValue());
                number -= entry.getKey();
            }
        }
        return result.toString();
    }

    @Override
    public int toArabic(RomanNumeral romanNumeral) {
        String roman = romanNumeral.getValue();
        int result = 0;
        int previousValue = 0;
        for (int i = 0; i < roman.length(); i++) {
            String currentSymbol = roman.substring(i, i + 1);
            int currentValue = romanToArabicMap.get(currentSymbol);

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
