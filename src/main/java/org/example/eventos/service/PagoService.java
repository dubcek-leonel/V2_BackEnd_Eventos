package org.example.eventos.service;

import org.example.eventos.dto.PagoDTO;
import java.util.List;

public interface PagoService {

    List<PagoDTO> findAll();

    PagoDTO findById(long id);

    PagoDTO create(PagoDTO pagoDTO);

    PagoDTO update(long id, PagoDTO pagoDTO);

    void delete(long id);
}
