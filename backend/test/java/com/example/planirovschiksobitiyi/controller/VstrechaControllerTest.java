package com.example.planirovschiksobitiyi.controller;

import com.example.planirovschiksobitiyi.model.Vstrecha;
import com.example.planirovschiksobitiyi.service.VstrechaService;
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

@WebMvcTest(VstrechaController.class)
public class VstrechaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VstrechaService vstrechaService;

    @Test
    public void testSozdatVstrechu() throws Exception {
        Vstrecha vstrecha = new Vstrecha();
        vstrecha.setId(1L);

        when(vstrechaService.sozdatVstrechu(any(Vstrecha.class))).thenReturn(vstrecha);

        mockMvc.perform(post("/api/vstrechi")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    // Добавьте другие тесты для остальных методов контроллера
}