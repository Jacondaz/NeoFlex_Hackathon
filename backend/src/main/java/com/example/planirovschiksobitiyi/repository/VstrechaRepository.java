package com.example.planirovschiksobitiyi.repository;

import com.example.planirovschiksobitiyi.model.Vstrecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VstrechaRepository extends JpaRepository<Vstrecha, Long> {
    List<Vstrecha> findByVremyaNachalaBetween(LocalDateTime start, LocalDateTime end);
    List<Vstrecha> findByUchastniki_Id(Long userId);
}