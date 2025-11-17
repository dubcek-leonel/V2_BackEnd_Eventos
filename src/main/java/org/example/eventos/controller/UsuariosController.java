package org.example.eventos.controller;


import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.UsuariosDTO;
import org.example.eventos.service.UsuariosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UsuariosController {

    private final UsuariosService usuariosService;

    @GetMapping
    private List<UsuariosDTO> getUsuarios(){
        return usuariosService.findAllUsers();
    }

    @GetMapping("/{id}")
    private UsuariosDTO getUsuarioById(@PathVariable Long id) {
        return usuariosService.findUserById(id);
    }

    @PostMapping
    private UsuariosDTO createUsuario(@RequestBody UsuariosDTO usuariosDTO) {
        return usuariosService.createUser(usuariosDTO);
    }

    @PutMapping("/{id}")
    private UsuariosDTO updateUsuario(@PathVariable Long id, @RequestBody UsuariosDTO usuariosDTO) {
        return usuariosService.updateUser(id, usuariosDTO);
    }

    @DeleteMapping("/{id}")
    private void deleteUsuario(@PathVariable Long id) {
        usuariosService.deleteUser(id);
    }
}
