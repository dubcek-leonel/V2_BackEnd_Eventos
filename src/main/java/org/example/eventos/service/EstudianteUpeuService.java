package org.example.eventos.service;

import org.example.eventos.dto.EstudianteUpeuDTO;
import java.util.List;

public interface EstudianteUpeuService {
    List<EstudianteUpeuDTO> findAll();
    EstudianteUpeuDTO findByCodigo(Long codigo);
    EstudianteUpeuDTO create(EstudianteUpeuDTO dto);
    EstudianteUpeuDTO update(Long codigo, EstudianteUpeuDTO dto);
    void delete(Long codigo);
}
