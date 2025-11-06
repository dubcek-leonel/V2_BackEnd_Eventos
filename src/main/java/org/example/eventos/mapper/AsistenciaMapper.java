package org.example.eventos.mapper;

import org.example.eventos.dto.AsistenciaDTO;
import org.example.eventos.dto.EventoDTO;
import org.example.eventos.entity.AsistenciaEntity;
import org.example.eventos.entity.EventoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsistenciaMapper {

    AsistenciaMapper INSTANCE = Mappers.getMapper(AsistenciaMapper.class);

    AsistenciaDTO asistenciaEntityAAsistenciaDTO(AsistenciaEntity asistenciaEntity);

    List<AsistenciaDTO> asistenciaEntitiesAAsistenciaDTOs(List<AsistenciaEntity> asistenciasEntity);

    AsistenciaEntity AsistenciaDTOAAsistenciaEntity(AsistenciaDTO asistenciaDTO);

}