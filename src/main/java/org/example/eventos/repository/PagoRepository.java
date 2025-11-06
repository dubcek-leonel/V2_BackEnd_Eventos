package org.example.eventos.repository;

import org.example.eventos.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository <PagoEntity, Long> {
}
