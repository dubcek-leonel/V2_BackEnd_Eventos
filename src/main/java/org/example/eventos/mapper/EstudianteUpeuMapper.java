package org.example.eventos.mapper;

import org.example.eventos.dto.EstudianteUpeuDTO;
import org.example.eventos.entity.EstudianteUpeuEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteUpeuMapper {

    EstudianteUpeuDTO estudianteUpeuEntityToEstudianteUpeuDTO(EstudianteUpeuEntity estudianteUpeuEntity);

    List<EstudianteUpeuDTO> estudianteUpeuEntitiesToEstudianteUpeuDTOs(List<EstudianteUpeuEntity> estudianteUpeuEntities);

    EstudianteUpeuEntity estudianteUpeuDTOToEstudianteUpeuEntity(EstudianteUpeuDTO estudianteUpeuDTO);
}
