package com.example.planirovschiksobitiyi.service;

import com.example.planirovschiksobitiyi.dto.PolzovatelDTO;
import com.example.planirovschiksobitiyi.model.Polzovatel;
import com.example.planirovschiksobitiyi.repository.PolzovatelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PolzovatelService {
    private final PolzovatelRepository polzovatelRepository;

    public PolzovatelDTO sozdatPolzovatelya(PolzovatelDTO polzovatelDTO) {
        Polzovatel polzovatel = convertToEntity(polzovatelDTO);
        polzovatel = polzovatelRepository.save(polzovatel);
        return convertToDTO(polzovatel);
    }

    public PolzovatelDTO poluchitPolzovatelya(Long id) {
        Polzovatel polzovatel = polzovatelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return convertToDTO(polzovatel);
    }

    public List<PolzovatelDTO> poluchitVsehPolzovateley() {
        return polzovatelRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PolzovatelDTO obnovitPolzovatelya(Long id, PolzovatelDTO polzovatelDTO) {
        Polzovatel polzovatel = polzovatelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        updatePolzovatelFromDTO(polzovatel, polzovatelDTO);
        polzovatel = polzovatelRepository.save(polzovatel);
        return convertToDTO(polzovatel);
    }

    public void udalitPolzovatelya(Long id) {
        polzovatelRepository.deleteById(id);
    }

    private Polzovatel convertToEntity(PolzovatelDTO polzovatelDTO) {
        Polzovatel polzovatel = new Polzovatel();
        updatePolzovatelFromDTO(polzovatel, polzovatelDTO);
        return polzovatel;
    }

    private void updatePolzovatelFromDTO(Polzovatel polzovatel, PolzovatelDTO polzovatelDTO) {
        polzovatel.setImya(polzovatelDTO.getImya());
        polzovatel.setFamiliya(polzovatelDTO.getFamiliya());
        polzovatel.setEmail(polzovatelDTO.getEmail());
        polzovatel.setRol(polzovatelDTO.getRol());
    }

    private PolzovatelDTO convertToDTO(Polzovatel polzovatel) {
        PolzovatelDTO polzovatelDTO = new PolzovatelDTO();
        polzovatelDTO.setId(polzovatel.getId());
        polzovatelDTO.setImya(polzovatel.getImya());
        polzovatelDTO.setFamiliya(polzovatel.getFamiliya());
        polzovatelDTO.setEmail(polzovatel.getEmail());
        polzovatelDTO.setRol(polzovatel.getRol());
        return polzovatelDTO;
    }
}