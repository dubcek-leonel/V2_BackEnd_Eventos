package org.example.eventos.mapper;

import org.example.eventos.dto.FechaeventoDTO;
import org.example.eventos.entity.FechaeventoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FechaeventoMapper {

    FechaeventoMapper INSTANCE = Mappers.getMapper(FechaeventoMapper.class);

    FechaeventoDTO fechaeventoEntityAFechaeventoDTO(FechaeventoEntity fechaeventoEntity);

    List<FechaeventoDTO> fechaeventoEntitiesAFechaeventoDTOs(List<FechaeventoEntity> fechaeventoEntity);

    FechaeventoEntity FechaeventoDTOAFechaeventoEntity(FechaeventoDTO fechaeventoDTO);
}
