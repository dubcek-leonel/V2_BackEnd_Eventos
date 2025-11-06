package org.example.eventos.controller;

import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.InscripcionesDTO;
import org.example.eventos.service.InscripcionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class InscripcionesController {

    private final InscripcionesService inscripcionesService;

    @GetMapping
    public List<InscripcionesDTO> getAllInscripciones() {
        return inscripcionesService.findAll();
    }
    @GetMapping("/{id}")
    public InscripcionesDTO getInscripcionById(@PathVariable Long id) {
        return inscripcionesService.findById(id);
    }

    @PostMapping
    public InscripcionesDTO createInscripcion(@RequestBody InscripcionesDTO inscripcionesDTO) {
        return inscripcionesService.create(inscripcionesDTO);
    }

    @PutMapping("/{id}")
    public InscripcionesDTO updateInscripcion(@PathVariable Long id, @RequestBody InscripcionesDTO inscripcionesDTO) {
        return inscripcionesService.update(id, inscripcionesDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteInscripcion(@PathVariable Long id) {
        inscripcionesService.delete(id);
    }
}
