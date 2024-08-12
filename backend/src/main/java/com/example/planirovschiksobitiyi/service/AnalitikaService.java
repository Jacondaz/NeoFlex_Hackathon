package com.example.planirovschiksobitiyi.service;

import com.example.planirovschiksobitiyi.dto.AnalitikaDTO;
import com.example.planirovschiksobitiyi.model.Vstrecha;
import com.example.planirovschiksobitiyi.repository.VstrechaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalitikaService {
    private final VstrechaRepository vstrechaRepository;

    public List<AnalitikaDTO> poluchitAnalitiku(LocalDateTime nachalo, LocalDateTime konec) {
        List<Vstrecha> vstrechi = vstrechaRepository.findByVremyaNachalaBetween(nachalo, konec);
        
        List<AnalitikaDTO> analitika = new ArrayList<>();

        // Подсчет общего количества встреч
        AnalitikaDTO obshcheeKolichestvo = new AnalitikaDTO();
        obshcheeKolichestvo.setPokazatel("Общее количество встреч");
        obshcheeKolichestvo.setZnachenie((long) vstrechi.size());
        analitika.add(obshcheeKolichestvo);

        // Статистика по статусам
        Map<Vstrecha.StatusVstrechi, Long> statistikaPoStatusam = vstrechi.stream()
                .collect(Collectors.groupingBy(Vstrecha::getStatus, Collectors.counting()));

        statistikaPoStatusam.forEach((status, kolichestvo) -> {
            AnalitikaDTO statusAnalitika = new AnalitikaDTO();
            statusAnalitika.setPokazatel("Количество встреч со статусом " + status);
            statusAnalitika.setZnachenie(kolichestvo);
            analitika.add(statusAnalitika);
        });

        return analitika;
    }
}