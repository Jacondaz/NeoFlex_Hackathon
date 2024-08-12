package com.example.planirovschiksobitiyi.controller;

import com.example.planirovschiksobitiyi.dto.AnalitikaDTO;
import com.example.planirovschiksobitiyi.service.AnalitikaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/analitika")
@RequiredArgsConstructor
public class AnalitikaController {
    private final AnalitikaService analitikaService;

    @GetMapping
    public ResponseEntity<List<AnalitikaDTO>> poluchitAnalitiku(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime nachalo,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime konec) {
        return ResponseEntity.ok(analitikaService.poluchitAnalitiku(nachalo, konec));
    }
}