package org.example.eventos.service;

import org.example.eventos.dto.MetodoPagoEventoDTO;
import java.util.List;

public interface MetodoPagoEventoService {

    List<MetodoPagoEventoDTO> findAll();

    MetodoPagoEventoDTO findById(Long id);

    MetodoPagoEventoDTO create(MetodoPagoEventoDTO metodoPagoEventoDTO);

    MetodoPagoEventoDTO update(Long id, MetodoPagoEventoDTO metodoPagoEventoDTO);

    void delete(Long id);
}
