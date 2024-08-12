package com.example.planirovschiksobitiyi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "vstrechi")
public class Vstrecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vremya_nachala")
    private LocalDateTime vremyaNachala;

    @Column(name = "vremya_okonchaniya")
    private LocalDateTime vremyaOkonchaniya;

    @ManyToMany
    @JoinTable(
        name = "uchastniki_vstrechi",
        joinColumns = @JoinColumn(name = "vstrecha_id"),
        inverseJoinColumns = @JoinColumn(name = "polzovatel_id")
    )
    private Set<Polzovatel> uchastniki;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusVstrechi status;

    public enum StatusVstrechi {
        ZAPLANIROVANA, ZAVERSHENA, OTMENENA
    }
}