package org.example.eventos.controller;

import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.MetodoPagoEventoDTO;
import org.example.eventos.service.MetodoPagoEventoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodo-pagos-eventos")
@RequiredArgsConstructor
public class MetodoPagoEventoController {

    private final MetodoPagoEventoService metodoPagoEventoService;

    @GetMapping
    private List<MetodoPagoEventoDTO> findAll() {
        return metodoPagoEventoService.findAll();
    }

    @GetMapping("/{id}")
    private MetodoPagoEventoDTO findById(@PathVariable Long id) {
        return metodoPagoEventoService.findById(id);
    }

    @PostMapping
    private MetodoPagoEventoDTO create(@RequestBody MetodoPagoEventoDTO metodoPagoEventoDTO) {
        return metodoPagoEventoService.create(metodoPagoEventoDTO);
    }

    @PutMapping("/{id}")
    private MetodoPagoEventoDTO update(@PathVariable Long id, @RequestBody MetodoPagoEventoDTO metodoPagoEventoDTO) {
        return metodoPagoEventoService.update(id, metodoPagoEventoDTO);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        metodoPagoEventoService.delete(id);
    }
}
