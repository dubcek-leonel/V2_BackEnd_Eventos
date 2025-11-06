package org.example.eventos.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.eventos.dto.EventoDTO;
import org.example.eventos.entity.EventoEntity;
import org.example.eventos.mapper.EventoMapper;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoMapper eventoMapper;

    @Override
    public List<EventoDTO> listarTodos() {
        return eventoMapper.eventosEntitiesAEventoDTOs(eventoRepository.findAll());
    }

    @Override
    public EventoDTO obtenerPorId(Long id) {
        EventoEntity eventoEntity = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        return eventoMapper.eventoEntityAEventoDTO(eventoEntity);
    }

    @Override
    public EventoDTO crear(EventoDTO eventoDTO) {
        EventoEntity eventoEntity = eventoMapper.EventoDTOAEventoEntity(eventoDTO);
        // 🔹 No pongas ID aquí — debe generarse automáticamente
        EventoEntity guardado = eventoRepository.save(eventoEntity);
        return eventoMapper.eventoEntityAEventoDTO(guardado);
    }

    @Override
    public EventoDTO actualizar(Long id, EventoDTO eventoDTO) {
        EventoEntity eventoEntity = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));

        // 🔹 Actualiza solo los campos editables
        eventoEntity.setNombre(eventoDTO.getNombre());
        eventoEntity.setDescripcion(eventoDTO.getDescripcion());
        eventoEntity.setTipo(eventoDTO.getTipo());
        eventoEntity.setCategoria(eventoDTO.getCategoria());
        eventoEntity.setUbicacion(eventoDTO.getUbicacion());
        eventoEntity.setCapacidad(eventoDTO.getCapacidad());
        eventoEntity.setEsPago(eventoDTO.getEsPago());
        eventoEntity.setPrecio(eventoDTO.getPrecio());
        eventoEntity.setImagenUrl(eventoDTO.getImagenUrl());
        eventoEntity.setEstado(eventoDTO.getEstado());
        eventoEntity.setActualizadoPor(eventoDTO.getActualizadoPor());

        // 🔸 Actualiza la fecha de modificación automáticamente
        eventoEntity.setUpdatedAt(LocalDateTime.now());

        // 🔸 No tocar la fecha de creación (la mantiene Hibernate)
        EventoEntity actualizado = eventoRepository.save(eventoEntity);

        return eventoMapper.eventoEntityAEventoDTO(actualizado);
    }




    @Override
    public void eliminar(Long id) {
        if (!eventoRepository.existsById(id)) {
            throw new EntityNotFoundException("Evento no encontrado");
        }
        eventoRepository.deleteById(id);
    }
}
