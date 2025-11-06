package org.example.eventos.repository;

import org.example.eventos.entity.FechaeventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FechaeventoRepository extends JpaRepository<FechaeventoEntity, Long> {
}
