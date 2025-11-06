package org.example.eventos.repository;

import org.example.eventos.entity.InscripcionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionesRepository extends JpaRepository<InscripcionesEntity, Long> {
}
