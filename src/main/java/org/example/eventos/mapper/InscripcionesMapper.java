package org.example.eventos.mapper;

import org.example.eventos.dto.InscripcionesDTO;
import org.example.eventos.entity.InscripcionesEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscripcionesMapper {

    InscripcionesDTO inscripcionEntityToInscripcionDTO(InscripcionesEntity inscripcionesEntity);

    List<InscripcionesDTO> inscripcionEntityToInscripcionDTOs(List<InscripcionesEntity> inscripcionesEntities);

    InscripcionesEntity inscripcionDTOToInscripcionEntity(InscripcionesDTO inscripcionesDTO);
}
