package org.example.eventos.controller;

import jakarta.validation.Valid;
import org.example.eventos.dto.EventoDTO;
import org.example.eventos.dto.FechaeventoDTO;
import org.example.eventos.service.EventoService;
import org.example.eventos.service.FechaeventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fechaevento")
public class FechaeventoController {

    @Autowired
    private FechaeventoService fechaeventoService;

    @GetMapping
    public ResponseEntity<List<FechaeventoDTO>> listar() {
        return new ResponseEntity<>(fechaeventoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FechaeventoDTO> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(fechaeventoService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FechaeventoDTO> crear(@Valid @RequestBody FechaeventoDTO fechaeventoDTO) {
        return new ResponseEntity<>(fechaeventoService.crear(fechaeventoDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FechaeventoDTO> editar(@PathVariable Long id, @Valid @RequestBody FechaeventoDTO fechaeventoDTO) {
        return new ResponseEntity<>(fechaeventoService.actualizar(id, fechaeventoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        fechaeventoService.eliminar(id);
        return new ResponseEntity<>("eliminado", HttpStatus.OK);
    }
}
