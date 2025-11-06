package org.example.eventos.mapper;

import org.example.eventos.dto.MetodoPagoEventoDTO;
import org.example.eventos.entity.MetodoPagoEventoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MetodoPagoEventoMapper {

    MetodoPagoEventoDTO metodoPagoEventoEntityToMetodoPagoEventoDTO(MetodoPagoEventoEntity metodoPagoEventoEntity);

    List<MetodoPagoEventoDTO> metodoPagoEventoEntitiesToMetodoPagoEventoDTOs(List<MetodoPagoEventoEntity> metodoPagoEventoEntities);

    MetodoPagoEventoEntity metodoPagoEventoDTOToMetodoPagoEventoEntity(MetodoPagoEventoDTO metodoPagoEventoDTO);
}
