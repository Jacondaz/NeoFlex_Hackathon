package com.example.planirovschiksobitiyi.dto;

import com.example.planirovschiksobitiyi.model.Vstrecha;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class VstrechaDTO {
    private Long id;
    private LocalDateTime vremyaNachala;
    private LocalDateTime vremyaOkonchaniya;
    private Set<Long> uchastnikiIds;
    private Vstrecha.StatusVstrechi status;
}