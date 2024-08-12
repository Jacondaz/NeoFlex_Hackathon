package com.example.planirovschiksobitiyi.controller;

import com.example.planirovschiksobitiyi.dto.PolzovatelDTO;
import com.example.planirovschiksobitiyi.service.PolzovatelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polzovateli")
@RequiredArgsConstructor
public class PolzovatelController {
    private final PolzovatelService polzovatelService;

    @PostMapping
    public ResponseEntity<PolzovatelDTO> sozdatPolzovatelya(@RequestBody PolzovatelDTO polzovatelDTO) {
        return ResponseEntity.ok(polzovatelService.sozdatPolzovatelya(polzovatelDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolzovatelDTO> poluchitPolzovatelya(@PathVariable Long id) {
        return ResponseEntity.ok(polzovatelService.poluchitPolzovatelya(id));
    }

    @GetMapping
    public ResponseEntity<List<PolzovatelDTO>> poluchitVsehPolzovateley() {
        return ResponseEntity.ok(polzovatelService.poluchitVsehPolzovateley());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolzovatelDTO> obnovitPolzovatelya(@PathVariable Long id, @RequestBody PolzovatelDTO polzovatelDTO) {
        return ResponseEntity.ok(polzovatelService.obnovitPolzovatelya(id, polzovatelDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> udalitPolzovatelya(@PathVariable Long id) {
        polzovatelService.udalitPolzovatelya(id);
        return ResponseEntity.noContent().build();
    }
}