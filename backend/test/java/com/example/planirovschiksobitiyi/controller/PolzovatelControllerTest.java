package com.example.planirovschiksobitiyi.controller;

import com.example.planirovschiksobitiyi.dto.PolzovatelDTO;
import com.example.planirovschiksobitiyi.model.Polzovatel;
import com.example.planirovschiksobitiyi.service.PolzovatelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PolzovatelController.class)
public class PolzovatelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PolzovatelService polzovatelService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSozdatPolzovatelya() throws Exception {
        PolzovatelDTO polzovatelDTO = new PolzovatelDTO();
        polzovatelDTO.setImya("Иван");
        polzovatelDTO.setFamiliya("Иванов");
        polzovatelDTO.setEmail("ivan@example.com");
        polzovatelDTO.setRol(Polzovatel.RolPolzovatelya.KANDIDAT);

        when(polzovatelService.sozdatPolzovatelya(any(PolzovatelDTO.class))).thenReturn(polzovatelDTO);

        mockMvc.perform(post("/api/polzovateli")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(polzovatelDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imya").value("Иван"))
                .andExpect(jsonPath("$.familiya").value("Иванов"))
                .andExpect(jsonPath("$.email").value("ivan@example.com"))
                .andExpect(jsonPath("$.rol").value("KANDIDAT"));
    }

    // Добавьте другие тесты для остальных методов контроллера
}