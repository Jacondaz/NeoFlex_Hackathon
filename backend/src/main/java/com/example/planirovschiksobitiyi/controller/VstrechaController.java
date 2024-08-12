package com.example.planirovschiksobitiyi.controller;

import com.example.planirovschiksobitiyi.dto.VstrechaDTO;
import com.example.planirovschiksobitiyi.service.VstrechaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vstrechi")
@RequiredArgsConstructor
public class VstrechaController {
    private final VstrechaService vstrechaService;

    @PostMapping
    public ResponseEntity<VstrechaDTO> sozdatVstrechu(@RequestBody VstrechaDTO vstrechaDTO) {
        return ResponseEntity.ok(vstrechaService.sozdatVstrechu(vstrechaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VstrechaDTO> poluchitVstrechu(@PathVariable Long id) {
        return ResponseEntity.ok(vstrechaService.poluchitVstrechu(id));
    }

    @GetMapping
    public ResponseEntity<List<VstrechaDTO>> poluchitVseVstrechi() {
        return ResponseEntity.ok(vstrechaService.poluchitVseVstrechi());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VstrechaDTO> obnovitVstrechu(@PathVariable Long id, @RequestBody VstrechaDTO vstrechaDTO) {
        return ResponseEntity.ok(vstrechaService.obnovitVstrechu(id, vstrechaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> udalitVstrechu(@PathVariable Long id) {
        vstrechaService.udalitVstrechu(id);
        return ResponseEntity.noContent().build();
    }
}