package org.example.eventos.controller;

import jakarta.validation.Valid;
import org.example.eventos.dto.AsistenciaDTO;
import org.example.eventos.dto.EventoDTO;
import org.example.eventos.service.AsistenciaService;
import org.example.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public ResponseEntity<List<AsistenciaDTO>> listar() {
        return new ResponseEntity<>(asistenciaService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(asistenciaService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AsistenciaDTO> crear(@Valid @RequestBody AsistenciaDTO asistenciaDTO) {
        return new ResponseEntity<>(asistenciaService.crear(asistenciaDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> editar(@PathVariable Long id, @Valid @RequestBody AsistenciaDTO asistenciaDTO) {
        return new ResponseEntity<>(asistenciaService.actualizar(id, asistenciaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        asistenciaService.eliminar(id);
        return new ResponseEntity<>("eliminado", HttpStatus.OK);
    }
}
