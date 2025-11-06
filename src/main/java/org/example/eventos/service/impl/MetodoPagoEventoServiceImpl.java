package org.example.eventos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.MetodoPagoEventoDTO;
import org.example.eventos.entity.EventoEntity;
import org.example.eventos.entity.MetodoPagoEventoEntity;
import org.example.eventos.mapper.MetodoPagoEventoMapper;
import org.example.eventos.repository.EventoRepository;
import org.example.eventos.repository.MetodoPagoEventoRepository;
import org.example.eventos.service.MetodoPagoEventoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetodoPagoEventoServiceImpl implements MetodoPagoEventoService {

    private final MetodoPagoEventoRepository metodoPagoEventoRepository;
    private final EventoRepository eventoRepository;
    private final MetodoPagoEventoMapper metodoPagoEventoMapper;

    @Override
    public List<MetodoPagoEventoDTO> findAll() {
        return metodoPagoEventoMapper.metodoPagoEventoEntitiesToMetodoPagoEventoDTOs(
                metodoPagoEventoRepository.findAll()
        );
    }

    @Override
    public MetodoPagoEventoDTO findById(Long id) {
        return metodoPagoEventoRepository.findById(id)
                .map(metodoPagoEventoMapper::metodoPagoEventoEntityToMetodoPagoEventoDTO)
                .orElse(null);
    }

    @Override
    public MetodoPagoEventoDTO create(MetodoPagoEventoDTO metodoPagoEventoDTO) {
        MetodoPagoEventoEntity entity = metodoPagoEventoMapper.metodoPagoEventoDTOToMetodoPagoEventoEntity(metodoPagoEventoDTO);

        if (metodoPagoEventoDTO.getEventoId() != null) {
            EventoEntity evento = eventoRepository.findById(metodoPagoEventoDTO.getEventoId())
                    .orElseThrow(() -> new RuntimeException("Evento not found"));
            entity.setEvento(evento);
        }

        MetodoPagoEventoEntity saved = metodoPagoEventoRepository.save(entity);
        return metodoPagoEventoMapper.metodoPagoEventoEntityToMetodoPagoEventoDTO(saved);
    }

    @Override
    public MetodoPagoEventoDTO update(Long id, MetodoPagoEventoDTO metodoPagoEventoDTO) {
        MetodoPagoEventoEntity existing = metodoPagoEventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MetodoPagoEvento not found"));

        existing.setNombreMetodo(metodoPagoEventoDTO.getNombreMetodo());
        existing.setDescripcion(metodoPagoEventoDTO.getDescripcion());
        existing.setActivo(metodoPagoEventoDTO.getActivo());

        if (metodoPagoEventoDTO.getEventoId() != null) {
            EventoEntity evento = eventoRepository.findById(metodoPagoEventoDTO.getEventoId())
                    .orElseThrow(() -> new RuntimeException("Evento not found"));
            existing.setEvento(evento);
        }

        MetodoPagoEventoEntity updated = metodoPagoEventoRepository.save(existing);
        return metodoPagoEventoMapper.metodoPagoEventoEntityToMetodoPagoEventoDTO(updated);
    }

    @Override
    public void delete(Long id) {
        metodoPagoEventoRepository.deleteById(id);
    }
}
