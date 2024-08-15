package com.romannumerals.challenge.infraestructure.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testConvertToRoman_ValidRequest() throws Exception {
        mockMvc.perform(get("/convert/to-roman")
                        .param("number", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("X"));
    }

    @Test
    void testConvertToRoman_InvalidRequest() throws Exception {
        mockMvc.perform(get("/convert/to-roman")
                        .param("number", "4000")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()) // O el código que retorne tu manejo de excepciones
                .andExpect(content().json("{'message':'Argumentos inválidos.'}"));
    }

    @Test
    void testConvertToArabic_ValidRequest() throws Exception {
        mockMvc.perform(get("/convert/to-arabic")
                        .param("roman", "X")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    void testConvertToArabic_InvalidRequest() throws Exception {
        mockMvc.perform(get("/convert/to-arabic")
                        .param("roman", "IIII")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()) // O el código que retorne tu manejo de excepciones
                .andExpect(content().json("{'message':'Argumentos inválidos.'}"));
    }
}