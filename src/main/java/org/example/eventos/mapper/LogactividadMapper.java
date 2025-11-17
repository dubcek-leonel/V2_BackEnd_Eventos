package org.example.eventos.mapper;

import org.example.eventos.dto.LogactividadDTO;

import org.example.eventos.entity.LogactividadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogactividadMapper {

    LogactividadMapper INSTANCE = Mappers.getMapper(LogactividadMapper.class);

    LogactividadDTO logactividadEntityALogactividadDTO(LogactividadEntity logactividadEntity);

    List<LogactividadDTO> logactividadEntitiesALogactividadDTOs(List<LogactividadEntity> logactividadEntity);

    LogactividadEntity LogactividadDTOALogactividadEntity(LogactividadDTO logactividadDTO);
}
