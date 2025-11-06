package org.example.eventos.service;


import org.example.eventos.dto.UsuariosDTO;

import java.util.List;

public interface UsuariosService {

    List<UsuariosDTO> findAllUsers();

    UsuariosDTO findUserById(Long id);

    UsuariosDTO createUser(UsuariosDTO usuariosDTO);

    UsuariosDTO updateUser(Long id, UsuariosDTO usuariosDTO);

    void deleteUser(Long id);

}
