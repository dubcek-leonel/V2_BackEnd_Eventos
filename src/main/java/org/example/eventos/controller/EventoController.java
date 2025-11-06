package org.example.eventos.controller;

import jakarta.validation.Valid;
import org.example.eventos.dto.EventoDTO;
import org.example.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listar() {
        return new ResponseEntity<>(eventoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(eventoService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventoDTO> crear(@Valid @RequestBody EventoDTO eventoDTO) {
        return new ResponseEntity<>(eventoService.crear(eventoDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> editar(@PathVariable Long id, @Valid @RequestBody EventoDTO eventoDTO) {
        return new ResponseEntity<>(eventoService.actualizar(id, eventoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        eventoService.eliminar(id);
        return new ResponseEntity<>("eliminado", HttpStatus.OK);
    }
}
