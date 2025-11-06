package org.example.eventos.mapper;


import org.example.eventos.dto.UsuariosDTO;
import org.example.eventos.entity.UsuariosEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {

    UsuariosDTO userEntityToUserDTO(UsuariosEntity usuariosEntity);

    List<UsuariosDTO> userEntityToUserDTOs(List<UsuariosEntity> usuariosEntities);

    UsuariosEntity userDTOToUserEntity(UsuariosDTO usuariosDTO);
}
