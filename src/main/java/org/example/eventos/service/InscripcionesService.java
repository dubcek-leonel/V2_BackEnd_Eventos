package org.example.eventos.service;

import org.example.eventos.dto.InscripcionesDTO;

import java.util.List;

public interface InscripcionesService {

    List<InscripcionesDTO> findAll();

    InscripcionesDTO findById(Long id);

    InscripcionesDTO create(InscripcionesDTO inscripcionesDTO);

    InscripcionesDTO update(Long id, InscripcionesDTO inscripcionesDTO);

    void delete(Long id);
}
