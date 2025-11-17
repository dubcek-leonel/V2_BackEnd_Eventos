package org.example.eventos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.UsuariosDTO;
import org.example.eventos.entity.UsuariosEntity;
import org.example.eventos.mapper.UsuariosMapper;
import org.example.eventos.repository.UsuariosRepository;
import org.example.eventos.service.UsuariosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuariosServiceImpl implements UsuariosService {

    private final UsuariosRepository usuariosRepository;
    private final UsuariosMapper usuariosMapper;

    @Override
    public List<UsuariosDTO> findAllUsers() {
        return usuariosMapper.userEntityToUserDTOs(usuariosRepository.findAll());
    }

    @Override
    public UsuariosDTO findUserById(Long id) {
        UsuariosEntity usuariosEntity = usuariosRepository.findById(id).orElseThrow(()
        -> new RuntimeException("User not found with id: " + id));
        return usuariosMapper.userEntityToUserDTO(usuariosEntity);
    }

    @Override
    public UsuariosDTO createUser(UsuariosDTO usuariosDTO) {

        UsuariosEntity usuariosEntity = new UsuariosEntity();
        usuariosEntity.setNombre(usuariosDTO.getNombre());
        usuariosEntity.setApellidos(usuariosDTO.getApellidos());
        usuariosEntity.setEmail(usuariosDTO.getEmail());
        usuariosEntity.setCodigoEstudiante(usuariosDTO.getCodigoEstudiante());
        usuariosEntity.setRol(usuariosDTO.getRol());
        usuariosEntity.setActivo(usuariosDTO.isActivo());
        usuariosEntity.setAsistencias(usuariosDTO.getAsistencias());
        UsuariosEntity save = usuariosRepository.save(usuariosEntity);
        return usuariosMapper.userEntityToUserDTO(save);
    }

    @Override
    public UsuariosDTO updateUser(Long id, UsuariosDTO usuariosDTO) {

        if (usuariosRepository.findById(id).isPresent()) {
            UsuariosEntity usuariosEntity = new UsuariosEntity();
            usuariosEntity.setId(id);
            usuariosEntity.setNombre(usuariosDTO.getNombre());
            usuariosEntity.setApellidos(usuariosDTO.getApellidos());
            usuariosEntity.setEmail(usuariosDTO.getEmail());
            usuariosEntity.setCodigoEstudiante(usuariosDTO.getCodigoEstudiante());
            usuariosEntity.setRol(usuariosDTO.getRol());
            usuariosEntity.setActivo(usuariosDTO.isActivo());
            usuariosEntity.setAsistencias(usuariosDTO.getAsistencias());
            UsuariosEntity save = usuariosRepository.save(usuariosEntity);
            return usuariosMapper.userEntityToUserDTO(save);
        }throw new RuntimeException("User not found with id: " + id);


    }

    @Override
    public void deleteUser(Long id) {
        if (usuariosRepository.findById(id).isPresent()) {
            usuariosRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
