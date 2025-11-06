package org.example.eventos.repository;

import org.example.eventos.entity.AsistenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity,Long> {
}
