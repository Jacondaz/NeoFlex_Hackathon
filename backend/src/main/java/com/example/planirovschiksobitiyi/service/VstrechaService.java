package com.example.planirovschiksobitiyi.service;

import com.example.planirovschiksobitiyi.dto.VstrechaDTO;
import com.example.planirovschiksobitiyi.model.Polzovatel;
import com.example.planirovschiksobitiyi.model.Vstrecha;
import com.example.planirovschiksobitiyi.repository.PolzovatelRepository;
import com.example.planirovschiksobitiyi.repository.VstrechaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VstrechaService {
    private final VstrechaRepository vstrechaRepository;
    private final PolzovatelRepository polzovatelRepository;

    public VstrechaDTO sozdatVstrechu(VstrechaDTO vstrechaDTO) {
        Vstrecha vstrecha = convertToEntity(vstrechaDTO);
        vstrecha = vstrechaRepository.save(vstrecha);
        return convertToDTO(vstrecha);
    }

    public VstrechaDTO poluchitVstrechu(Long id) {
        Vstrecha vstrecha = vstrechaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Встреча не найдена"));
        return convertToDTO(vstrecha);
    }

    public List<VstrechaDTO> poluchitVseVstrechi() {
        return vstrechaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VstrechaDTO obnovitVstrechu(Long id, VstrechaDTO vstrechaDTO) {
        Vstrecha vstrecha = vstrechaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Встреча не найдена"));
        updateVstrechaFromDTO(vstrecha, vstrechaDTO);
        vstrecha = vstrechaRepository.save(vstrecha);
        return convertToDTO(vstrecha);
    }

    public void udalitVstrechu(Long id) {
        vstrechaRepository.deleteById(id);
    }

    private Vstrecha convertToEntity(VstrechaDTO vstrechaDTO) {
        Vstrecha vstrecha = new Vstrecha();
        updateVstrechaFromDTO(vstrecha, vstrechaDTO);
        return vstrecha;
    }

    private void updateVstrechaFromDTO(Vstrecha vstrecha, VstrechaDTO vstrechaDTO) {
        vstrecha.setVremyaNachala(vstrechaDTO.getVremyaNachala());
        vstrecha.setVremyaOkonchaniya(vstrechaDTO.getVremyaOkonchaniya());
        vstrecha.setStatus(vstrechaDTO.getStatus());
        vstrecha.setUchastniki(new HashSet<>(polzovatelRepository.findAllById(vstrechaDTO.getUchastnikiIds())));
    }

    private VstrechaDTO convertToDTO(Vstrecha vstrecha) {
        VstrechaDTO vstrechaDTO = new VstrechaDTO();
        vstrechaDTO.setId(vstrecha.getId());
        vstrechaDTO.setVremyaNachala(vstrecha.getVremyaNachala());
        vstrechaDTO.setVremyaOkonchaniya(vstrecha.getVremyaOkonchaniya());
        vstrechaDTO.setStatus(vstrecha.getStatus());
        vstrechaDTO.setUchastnikiIds(vstrecha.getUchastniki().stream()
                .map(Polzovatel::getId)
                .collect(Collectors.toSet()));
        return vstrechaDTO;
    }
}