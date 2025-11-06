package org.example.eventos.repository;

import org.example.eventos.entity.LogactividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LogactividadRepository extends JpaRepository<LogactividadEntity, Long> {
}
