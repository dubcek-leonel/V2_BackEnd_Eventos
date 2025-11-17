package org.example.eventos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventos.dto.EstudianteUpeuDTO;
import org.example.eventos.entity.EstudianteUpeuEntity;
import org.example.eventos.mapper.EstudianteUpeuMapper;
import org.example.eventos.repository.EstudianteUpeuRepository;
import org.example.eventos.service.EstudianteUpeuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteUpeuServiceImpl implements EstudianteUpeuService {

    private final EstudianteUpeuRepository repository;
    private final EstudianteUpeuMapper mapper;

    @Override
    public List<EstudianteUpeuDTO> findAll() {
        List<EstudianteUpeuEntity> entities = repository.findAll();
        return mapper.estudianteUpeuEntitiesToEstudianteUpeuDTOs(entities);
    }

    @Override
    public EstudianteUpeuDTO findByCodigo(Long codigo) {
        EstudianteUpeuEntity entity = repository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con código: " + codigo));
        return mapper.estudianteUpeuEntityToEstudianteUpeuDTO(entity);
    }

    @Override
    public EstudianteUpeuDTO create(EstudianteUpeuDTO dto) {
        EstudianteUpeuEntity entity = mapper.estudianteUpeuDTOToEstudianteUpeuEntity(dto);
        EstudianteUpeuEntity saved = repository.save(entity);
        return mapper.estudianteUpeuEntityToEstudianteUpeuDTO(saved);
    }

    @Override
    public EstudianteUpeuDTO update(Long codigo, EstudianteUpeuDTO dto) {
        EstudianteUpeuEntity existing = repository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con código: " + codigo));

        existing.setNombre(dto.getNombre());
        existing.setApellidos(dto.getApellidos());
        existing.setEmail(dto.getEmail());
        existing.setFacultad(dto.getFacultad());
        existing.setEscuelaProfesional(dto.getEscuelaProfesional());
        existing.setSemestre(dto.getSemestre());
        existing.setTelefono(dto.getTelefono());
        existing.setEstado(dto.getEstado());

        EstudianteUpeuEntity updated = repository.save(existing);
        return mapper.estudianteUpeuEntityToEstudianteUpeuDTO(updated);
    }

    @Override
    public void delete(Long codigo) {
        if (!repository.existsById(codigo)) {
            throw new RuntimeException("Estudiante no encontrado con código: " + codigo);
        }
        repository.deleteById(codigo);
    }
}
