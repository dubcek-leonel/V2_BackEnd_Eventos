package org.example.eventos.service;

import org.example.eventos.dto.FechaeventoDTO;

import java.util.List;

public interface FechaeventoService {

    List<FechaeventoDTO> listarTodos();
    FechaeventoDTO obtenerPorId(Long id);
    FechaeventoDTO crear(FechaeventoDTO fechaeventoDTO);
    FechaeventoDTO actualizar(Long id, FechaeventoDTO fechaeventoDTO);
    void eliminar(Long id);
}
