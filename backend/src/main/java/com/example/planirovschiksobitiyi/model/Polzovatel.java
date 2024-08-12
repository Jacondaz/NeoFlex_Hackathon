package com.example.planirovschiksobitiyi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "polzovateli")
public class Polzovatel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imya")
    private String imya;

    @Column(name = "familiya")
    private String familiya;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private RolPolzovatelya rol;

    public enum RolPolzovatelya {
        REKRUTER, EKSPERT, KANDIDAT
    }
}