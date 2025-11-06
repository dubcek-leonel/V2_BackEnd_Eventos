package org.example.eventos.mapper;

import org.example.eventos.dto.EventoDTO;
import org.example.eventos.entity.EventoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface EventoMapper {

    EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    EventoDTO eventoEntityAEventoDTO(EventoEntity eventoEntity);

    List<EventoDTO> eventosEntitiesAEventoDTOs(List<EventoEntity> eventosEntity);

    EventoEntity EventoDTOAEventoEntity(EventoDTO eventoDTO);
}
