package org.example.eventos.service;

import org.example.eventos.dto.LogactividadDTO;
import java.util.List;

public interface LogactividadService {

    List<LogactividadDTO> listarTodos();
    LogactividadDTO obtenerPorId(Long id);
    LogactividadDTO crear(LogactividadDTO logactividadDTO);
    LogactividadDTO actualizar(Long id, LogactividadDTO logactividadDTO);
    void eliminar(Long id);

}
