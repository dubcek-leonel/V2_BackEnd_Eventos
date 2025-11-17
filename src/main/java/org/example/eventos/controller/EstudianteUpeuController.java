package org.example.eventos.controller;

import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.EstudianteUpeuDTO;
import org.example.eventos.service.EstudianteUpeuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estudiantes-upeu")
@RequiredArgsConstructor
public class EstudianteUpeuController {

    private final EstudianteUpeuService service;

    @GetMapping
    public ResponseEntity<List<EstudianteUpeuDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<EstudianteUpeuDTO> getByCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(service.findByCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<EstudianteUpeuDTO> create(@RequestBody EstudianteUpeuDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<EstudianteUpeuDTO> update(@PathVariable String codigo, @RequestBody EstudianteUpeuDTO dto) {
        return ResponseEntity.ok(service.update(codigo, dto));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable String codigo) {
        service.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
