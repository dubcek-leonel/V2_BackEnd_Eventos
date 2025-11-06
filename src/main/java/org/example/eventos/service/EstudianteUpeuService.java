package org.example.eventos.service;

import org.example.eventos.dto.EstudianteUpeuDTO;
import java.util.List;

public interface EstudianteUpeuService {
    List<EstudianteUpeuDTO> findAll();
    EstudianteUpeuDTO findByCodigo(String codigo);
    EstudianteUpeuDTO create(EstudianteUpeuDTO dto);
    EstudianteUpeuDTO update(String codigo, EstudianteUpeuDTO dto);
    void delete(String codigo);
}
