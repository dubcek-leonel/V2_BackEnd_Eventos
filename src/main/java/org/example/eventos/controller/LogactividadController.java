package org.example.eventos.controller;

import jakarta.validation.Valid;
import org.example.eventos.dto.LogactividadDTO;
import org.example.eventos.service.LogactividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logactividad")

    public class LogactividadController {
    @Autowired
    private LogactividadService logactividadService;

    @GetMapping
    public ResponseEntity<List<LogactividadDTO>> listar() {
        return new ResponseEntity<>(logactividadService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogactividadDTO> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(logactividadService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LogactividadDTO> crear(@Valid @RequestBody LogactividadDTO logactividadDTO) {
        return new ResponseEntity<>(logactividadService.crear(logactividadDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<LogactividadDTO> editar(@PathVariable Long id, @Valid @RequestBody LogactividadDTO logactividadDTO) {
        return new ResponseEntity<>(logactividadService.actualizar(id, logactividadDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        logactividadService.eliminar(id);
        return new ResponseEntity<>("eliminado", HttpStatus.OK);
    }
}
