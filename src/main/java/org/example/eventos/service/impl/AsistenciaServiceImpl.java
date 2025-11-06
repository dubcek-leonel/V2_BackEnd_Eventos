package org.example.eventos.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.AsistenciaDTO;
import org.example.eventos.dto.EventoDTO;
import org.example.eventos.entity.AsistenciaEntity;
import org.example.eventos.entity.EventoEntity;
import org.example.eventos.mapper.AsistenciaMapper;
import org.example.eventos.repository.AsistenciaRepository;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private AsistenciaMapper asistenciaMapper;

    @Override
    public List<AsistenciaDTO> listarTodos() {
        return asistenciaMapper.asistenciaEntitiesAAsistenciaDTOs(asistenciaRepository.findAll());
    }

    @Override
    public AsistenciaDTO obtenerPorId(Long id) {
        AsistenciaEntity asistenciaEntity = asistenciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        return asistenciaMapper.asistenciaEntityAAsistenciaDTO(asistenciaEntity);
    }

    @Override
    public AsistenciaDTO crear(AsistenciaDTO asistenciaDTO) {
        AsistenciaEntity asistenciaEntity = asistenciaMapper.AsistenciaDTOAAsistenciaEntity(asistenciaDTO);
        // 🔹 No pongas ID aquí — debe generarse automáticamente
        AsistenciaEntity guardado = asistenciaRepository.save(asistenciaEntity);
        return asistenciaMapper.asistenciaEntityAAsistenciaDTO(guardado);
    }

    @Override
    public AsistenciaDTO actualizar(Long id, AsistenciaDTO asistenciaDTO) {
        AsistenciaEntity asistenciaEntity = asistenciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asistencia no encontrada"));

        // 🔹 Actualiza solo los campos editables
        asistenciaEntity.setFechaHoraRegistro(asistenciaDTO.getFechaHoraRegistro());
        asistenciaEntity.setMetodoRegistro(asistenciaDTO.getMetodoRegistro());
        asistenciaEntity.setNotas(asistenciaDTO.getNotas());

        // 🔸 Si tu entidad tiene campo updatedAt, se actualiza automáticamente
        // asistenciaEntity.setUpdatedAt(LocalDateTime.now());

        // 🔸 Guarda los cambios
        AsistenciaEntity actualizado = asistenciaRepository.save(asistenciaEntity);

        return asistenciaMapper.asistenciaEntityAAsistenciaDTO(actualizado);
    }



    @Override
    public void eliminar(Long id) {
        if (!asistenciaRepository.existsById(id)) {
            throw new EntityNotFoundException("Evento no encontrado");
        }
        asistenciaRepository.deleteById(id);
    }
}