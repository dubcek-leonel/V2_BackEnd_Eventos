package org.example.eventos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.InscripcionesDTO;

import org.example.eventos.entity.InscripcionesEntity;
import org.example.eventos.mapper.InscripcionesMapper;
import org.example.eventos.repository.InscripcionesRepository;
import org.example.eventos.service.InscripcionesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InscripcionesServiceImpl implements InscripcionesService {

    private final InscripcionesRepository inscripcionesRepository;

    private final InscripcionesMapper inscripcionesMapper;

    @Override
    public List<InscripcionesDTO> findAll() {
        return inscripcionesMapper.inscripcionEntityToInscripcionDTOs(inscripcionesRepository.findAll());
    }

    @Override
    public InscripcionesDTO findById(Long id) {

        InscripcionesEntity inscripcionesEntity = inscripcionesRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Inscripcion not found with id: " + id)
        );

        return inscripcionesMapper.inscripcionEntityToInscripcionDTO(inscripcionesEntity);
    }

    @Override
    public InscripcionesDTO create(InscripcionesDTO inscripcionesDTO) {

        InscripcionesEntity  inscripcionesEntity=  new InscripcionesEntity();
        inscripcionesEntity.setCodigoEstudiante(inscripcionesDTO.getCodigoEstudiante());
        inscripcionesEntity.setNombreEstudiante(inscripcionesDTO.getNombreEstudiante());
        inscripcionesEntity.setApellidosEstudiante(inscripcionesDTO.getApellidosEstudiante());
        inscripcionesEntity.setEmailEstudiante(inscripcionesDTO.getEmailEstudiante());
        inscripcionesEntity.setEstado(inscripcionesDTO.getEstado());
        inscripcionesEntity.setMetodoPago(inscripcionesDTO.getMetodoPago());
        inscripcionesEntity.setComprobantePagoURL(inscripcionesDTO.getComprobantePagoURL());
        inscripcionesEntity.setEsInscripcionMasiva(inscripcionesDTO.getEsInscripcionMasiva());
        inscripcionesEntity.setFechaInscripcion(inscripcionesDTO.getFechaInscripcion());
        inscripcionesEntity.setFechaConfirmacion(inscripcionesDTO.getFechaConfirmacion());
        InscripcionesEntity save = inscripcionesRepository.save(inscripcionesEntity);

        return inscripcionesMapper.inscripcionEntityToInscripcionDTO(save);
    }

    @Override
    public InscripcionesDTO update(Long id, InscripcionesDTO inscripcionesDTO) {
        if (inscripcionesRepository.findById(id).isPresent()) {
            InscripcionesEntity inscripcionesEntity = new InscripcionesEntity();
            inscripcionesEntity.setId(id);
            inscripcionesEntity.setCodigoEstudiante(inscripcionesDTO.getCodigoEstudiante());
            inscripcionesEntity.setNombreEstudiante(inscripcionesDTO.getNombreEstudiante());
            inscripcionesEntity.setApellidosEstudiante(inscripcionesDTO.getApellidosEstudiante());
            inscripcionesEntity.setEmailEstudiante(inscripcionesDTO.getEmailEstudiante());
            inscripcionesEntity.setEstado(inscripcionesDTO.getEstado());
            inscripcionesEntity.setMetodoPago(inscripcionesDTO.getMetodoPago());
            inscripcionesEntity.setComprobantePagoURL(inscripcionesDTO.getComprobantePagoURL());
            inscripcionesEntity.setEsInscripcionMasiva(inscripcionesDTO.getEsInscripcionMasiva());
            inscripcionesEntity.setFechaInscripcion(inscripcionesDTO.getFechaInscripcion());
            inscripcionesEntity.setFechaConfirmacion(inscripcionesDTO.getFechaConfirmacion());
            InscripcionesEntity save = inscripcionesRepository.save(inscripcionesEntity);
            return inscripcionesMapper.inscripcionEntityToInscripcionDTO(save);
        }throw new RuntimeException("Inscripcion not found with id: " + id);

    }

    @Override
    public void delete(Long id) {
        if (inscripcionesRepository.findById(id).isPresent()) {
            inscripcionesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Inscripcion not found with id: " + id);
        }

    }
}
