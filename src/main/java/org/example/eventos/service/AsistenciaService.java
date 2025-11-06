package org.example.eventos.service;

import org.example.eventos.dto.AsistenciaDTO;
import org.example.eventos.dto.EventoDTO;

import java.util.List;

public interface AsistenciaService {

    List<AsistenciaDTO> listarTodos();
    AsistenciaDTO obtenerPorId(Long id);
    AsistenciaDTO crear(AsistenciaDTO asistenciaDTO);
    AsistenciaDTO actualizar(Long id, AsistenciaDTO asistenciaDTO);
    void eliminar(Long id);
}
