package org.example.eventos.controller;

import org.example.eventos.dto.PagoDTO;
import org.example.eventos.service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> getAll() {
        List<PagoDTO> pagos = pagoService.findAll();
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> getById(@PathVariable Long id) {
        PagoDTO pago = pagoService.findById(id);
        if (pago != null) {
            return ResponseEntity.ok(pago);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PagoDTO> create(@RequestBody PagoDTO pagoDTO) {
        PagoDTO newPago = pagoService.create(pagoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(@PathVariable Long id, @RequestBody PagoDTO pagoDTO) {
        PagoDTO updatedPago = pagoService.update(id, pagoDTO);
        if (updatedPago != null) {
            return ResponseEntity.ok(updatedPago);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
