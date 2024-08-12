package com.example.planirovschiksobitiyi.repository;

import com.example.planirovschiksobitiyi.model.Polzovatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PolzovatelRepository extends JpaRepository<Polzovatel, Long> {
    List<Polzovatel> findByRol(Polzovatel.RolPolzovatelya rol);
}