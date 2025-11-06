package org.example.eventos.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.eventos.dto.FechaeventoDTO;
import org.example.eventos.entity.FechaeventoEntity;
import org.example.eventos.mapper.FechaeventoMapper;

import org.example.eventos.repository.FechaeventoRepository;
import org.example.eventos.service.FechaeventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FechaeventoServiceImpl implements FechaeventoService {

    @Autowired
    private FechaeventoRepository fechaeventoRepository;

    @Autowired
    private FechaeventoMapper fechaeventoMapper;

    @Override
    public List<FechaeventoDTO> listarTodos() {
        return fechaeventoMapper.fechaeventoEntitiesAFechaeventoDTOs(fechaeventoRepository.findAll());
    }

    @Override
    public FechaeventoDTO obtenerPorId(Long id) {
        FechaeventoEntity fechaeventoEntity = fechaeventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        return fechaeventoMapper.fechaeventoEntityAFechaeventoDTO(fechaeventoEntity);
    }

    @Override
    public FechaeventoDTO crear(FechaeventoDTO fechaeventoDTO) {
        FechaeventoEntity fechaeventoEntity = fechaeventoMapper.FechaeventoDTOAFechaeventoEntity(fechaeventoDTO);
        FechaeventoEntity guardado = fechaeventoRepository.save(fechaeventoEntity);
        return fechaeventoMapper.fechaeventoEntityAFechaeventoDTO(guardado);
    }

    @Override
    public FechaeventoDTO actualizar(Long id, FechaeventoDTO fechaeventoDTO) {
        FechaeventoEntity fechaeventoEntity = fechaeventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fecha de evento no encontrada"));

        fechaeventoEntity.setFechaInicio(fechaeventoDTO.getFechaInicio());
        fechaeventoEntity.setFechaFin(fechaeventoDTO.getFechaFin());
        fechaeventoEntity.setDescripcion(fechaeventoDTO.getDescripcion());
        fechaeventoEntity.setUpdatedAt(LocalDateTime.now());

        FechaeventoEntity actualizado = fechaeventoRepository.save(fechaeventoEntity);
        return fechaeventoMapper.fechaeventoEntityAFechaeventoDTO(actualizado);
    }


    @Override
    public void eliminar(Long id) {
        if (!fechaeventoRepository.existsById(id)) {
            throw new EntityNotFoundException("Evento no encontrado");
        }
        fechaeventoRepository.deleteById(id);
    }
}
