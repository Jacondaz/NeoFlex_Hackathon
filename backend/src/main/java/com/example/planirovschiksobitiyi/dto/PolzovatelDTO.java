package com.example.planirovschiksobitiyi.dto;

import com.example.planirovschiksobitiyi.model.Polzovatel;
import lombok.Data;

@Data
public class PolzovatelDTO {
    private Long id;
    private String imya;
    private String familiya;
    private String email;
    private Polzovatel.RolPolzovatelya rol;
}