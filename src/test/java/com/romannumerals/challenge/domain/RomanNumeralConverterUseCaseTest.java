package com.romannumerals.challenge.domain;

import com.romannumerals.challenge.application.exception.RomanNumeralException;
import com.romannumerals.challenge.infraestructure.service.RomanNumeralConverterUseCaseService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RomanNumeralConverterUseCaseTest {
    private final RomanNumeralConverterUseCaseService converter = new RomanNumeralConverterUseCaseService();


    @Test
    void testToRoman_ValidValues() {
        assertThat(converter.toRoman(1)).isEqualTo("I");
        assertThat(converter.toRoman(4)).isEqualTo("IV");
        assertThat(converter.toRoman(9)).isEqualTo("IX");
        assertThat(converter.toRoman(10)).isEqualTo("X");
        assertThat(converter.toRoman(21)).isEqualTo("XXI");
        assertThat(converter.toRoman(50)).isEqualTo("L");
        assertThat(converter.toRoman(100)).isEqualTo("C");
        assertThat(converter.toRoman(500)).isEqualTo("D");
        assertThat(converter.toRoman(1000)).isEqualTo("M");
    }

    @Test
    void testToArabic_ValidValues() {
        assertThat(converter.toArabic("I")).isEqualTo(1);
        assertThat(converter.toArabic("IV")).isEqualTo(4);
        assertThat(converter.toArabic("IX")).isEqualTo(9);
        assertThat(converter.toArabic("X")).isEqualTo(10);
        assertThat(converter.toArabic("XXI")).isEqualTo(21);
        assertThat(converter.toArabic("L")).isEqualTo(50);
        assertThat(converter.toArabic("C")).isEqualTo(100);
        assertThat(converter.toArabic("D")).isEqualTo(500);
        assertThat(converter.toArabic("M")).isEqualTo(1000);
    }

    @Test
    void testToRoman_InvalidValues() {
        assertThatThrownBy(() -> converter.toRoman(0))
                .isInstanceOf(RomanNumeralException.class);

        assertThatThrownBy(() -> converter.toRoman(4000))
                .isInstanceOf(RomanNumeralException.class);
    }

    @Test
    void testToArabic_InvalidValues() {
        assertThatThrownBy(() -> converter.toArabic("IIII"))
                .isInstanceOf(RomanNumeralException.class);

        assertThatThrownBy(() -> converter.toArabic(""))
                .isInstanceOf(RomanNumeralException.class);
    }
}
