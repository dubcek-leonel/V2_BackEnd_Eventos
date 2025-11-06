package org.example.eventos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
import org.example.eventos.dto.PagoDTO;
import org.example.eventos.entity.PagoEntity;

@Mapper(componentModel = "spring")
public interface PagoMapper {

    PagoDTO pagoEntityToPagoDTO(PagoEntity pagoEntity);

    List<PagoDTO> pagoEntitiesToPagoDTOs(List<PagoEntity> pagoEntities);

    PagoEntity pagoDTOToPagoEntity(PagoDTO pagoDTO);
}