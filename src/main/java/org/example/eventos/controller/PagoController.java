package org.example.eventos.controller;

import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.PagoDTO;
import org.example.eventos.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @GetMapping
    private List<PagoDTO> findAll() {
        return pagoService.findAll();
    }

    @GetMapping("/{id}")
    private PagoDTO findById(@PathVariable Long id) {
        return pagoService.findById(id);
    }

    @PostMapping
    private PagoDTO create(@RequestBody PagoDTO pagoDTO) {
        return pagoService.create(pagoDTO);
    }

    @PutMapping("/{id}")
    private PagoDTO update(@PathVariable Long id, @RequestBody PagoDTO pagoDTO) {
        return pagoService.update(id, pagoDTO);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        pagoService.delete(id);
    }
}
