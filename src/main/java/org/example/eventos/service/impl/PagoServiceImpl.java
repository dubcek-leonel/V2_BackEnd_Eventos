package org.example.eventos.service.impl;

import org.example.eventos.dto.PagoDTO;
import org.example.eventos.entity.PagoEntity;
import org.example.eventos.mapper.PagoMapper;
import org.example.eventos.repository.PagoRepository;
import org.example.eventos.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    public PagoServiceImpl(PagoRepository pagoRepository, PagoMapper pagoMapper) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public List<PagoDTO> findAll() {
        List<PagoEntity> pagos = pagoRepository.findAll();
        return pagoMapper.pagoEntitiesToPagoDTOs(pagos);
    }

    @Override
    public PagoDTO findById(long id) {
        Optional<PagoEntity> pago = pagoRepository.findById(id);
        return pago.map(pagoMapper::pagoEntityToPagoDTO).orElse(null);
    }

    @Override
    public PagoDTO create(PagoDTO pagoDTO) {
        PagoEntity pagoEntity = pagoMapper.pagoDTOToPagoEntity(pagoDTO);
        PagoEntity savedPago = pagoRepository.save(pagoEntity);
        return pagoMapper.pagoEntityToPagoDTO(savedPago);
    }

    @Override
    public PagoDTO update(long id, PagoDTO pagoDTO) {
        Optional<PagoEntity> optionalPago = pagoRepository.findById(id);
        if (optionalPago.isPresent()) {
            PagoEntity existingPago = optionalPago.get();
            PagoEntity updatedPago = pagoMapper.pagoDTOToPagoEntity(pagoDTO);
            updatedPago.setId(existingPago.getId());
            PagoEntity savedPago = pagoRepository.save(updatedPago);
            return pagoMapper.pagoEntityToPagoDTO(savedPago);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        pagoRepository.deleteById(id);
    }
}
