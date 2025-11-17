package org.example.eventos.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.LogactividadDTO;
import org.example.eventos.entity.LogactividadEntity;
import org.example.eventos.mapper.LogactividadMapper;
import org.example.eventos.repository.LogactividadRepository;
import org.example.eventos.service.LogactividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogactividadServiceImpl implements LogactividadService {

    @Autowired
    private LogactividadRepository logactividadRepository;

    @Autowired
    private LogactividadMapper logactividadMapper;

    @Override
    public List<LogactividadDTO> listarTodos() {
        return logactividadMapper.logactividadEntitiesALogactividadDTOs(logactividadRepository.findAll());
    }

    @Override
    public LogactividadDTO obtenerPorId(Long id) {
        LogactividadEntity logactividadEntity = logactividadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        return logactividadMapper.logactividadEntityALogactividadDTO(logactividadEntity);
    }

    @Override
    public LogactividadDTO crear(LogactividadDTO logactividadDTO) {
        LogactividadEntity logactividadEntity = logactividadMapper.LogactividadDTOALogactividadEntity(logactividadDTO);
        LogactividadEntity guardado = logactividadRepository.save(logactividadEntity);
        return logactividadMapper.logactividadEntityALogactividadDTO(guardado);
    }

    @Override
    public LogactividadDTO actualizar(Long id, LogactividadDTO logactividadDTO) {
        LogactividadEntity logactividadEntity = logactividadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));

        // 🔹 Actualiza solo los campos editables
        logactividadEntity.setAccion(logactividadDTO.getAccion());
        logactividadEntity.setEntidad(logactividadDTO.getEntidad());
        logactividadEntity.setEntidadId(logactividadDTO.getEntidadId());
        logactividadEntity.setDetalles(logactividadDTO.getDetalles());
        logactividadEntity.setDireccion(logactividadDTO.getDireccion());
        logactividadEntity.setUserAgent(logactividadDTO.getUserAgent());

        LogactividadEntity actualizado = logactividadRepository.save(logactividadEntity);
        return logactividadMapper.logactividadEntityALogactividadDTO(actualizado);
    }


    @Override
    public void eliminar(Long id) {
        if (!logactividadRepository.existsById(id)) {
            throw new EntityNotFoundException("Evento no encontrado");
        }
        logactividadRepository.deleteById(id);
    }
}