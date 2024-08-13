package com.romannumerals.challenge.infraestructure.service;

import com.romannumerals.challenge.application.exception.RomanNumeralException;
import com.romannumerals.challenge.domain.ArabicNumeral;
import com.romannumerals.challenge.domain.RomanNumeral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RomanNumeralConverterUseCaseServiceTest {

    @InjectMocks
    private RomanNumeralConverterUseCaseService converter;


    @Test
    void testToRoman_ValidValues() {
        assertThat(converter.toRoman(new ArabicNumeral(1))).isEqualTo("I");
        assertThat(converter.toRoman(new ArabicNumeral(4))).isEqualTo("IV");
        assertThat(converter.toRoman(new ArabicNumeral(9))).isEqualTo("IX");
        assertThat(converter.toRoman(new ArabicNumeral(10))).isEqualTo("X");
        assertThat(converter.toRoman(new ArabicNumeral(21))).isEqualTo("XXI");
        assertThat(converter.toRoman(new ArabicNumeral(50))).isEqualTo("L");
        assertThat(converter.toRoman(new ArabicNumeral(100))).isEqualTo("C");
        assertThat(converter.toRoman(new ArabicNumeral(500))).isEqualTo("D");
        assertThat(converter.toRoman(new ArabicNumeral(1000))).isEqualTo("M");
    }

    @Test
    void testToArabic_ValidValues() {
        assertThat(converter.toArabic(new RomanNumeral("I"))).isEqualTo(1);
        assertThat(converter.toArabic(new RomanNumeral("IV"))).isEqualTo(4);
        assertThat(converter.toArabic(new RomanNumeral("IX"))).isEqualTo(9);
        assertThat(converter.toArabic(new RomanNumeral("X"))).isEqualTo(10);
        assertThat(converter.toArabic(new RomanNumeral("XXI"))).isEqualTo(21);
        assertThat(converter.toArabic(new RomanNumeral("L"))).isEqualTo(50);
        assertThat(converter.toArabic(new RomanNumeral("C"))).isEqualTo(100);
        assertThat(converter.toArabic(new RomanNumeral("D"))).isEqualTo(500);
        assertThat(converter.toArabic(new RomanNumeral("M"))).isEqualTo(1000);
    }

    @Test
    void testToRoman_InvalidValues() {
        assertThatThrownBy(() -> converter.toRoman(new ArabicNumeral(0)))
                .isInstanceOf(RomanNumeralException.class);

        assertThatThrownBy(() -> converter.toRoman(new ArabicNumeral(4000)))
                .isInstanceOf(RomanNumeralException.class);
    }

    @Test
    void testToArabic_InvalidValues() {
        assertThatThrownBy(() -> converter.toArabic(new RomanNumeral("IIII")))
                .isInstanceOf(RomanNumeralException.class);

        assertThatThrownBy(() -> converter.toArabic(new RomanNumeral("")))
                .isInstanceOf(RomanNumeralException.class);
    }
}
