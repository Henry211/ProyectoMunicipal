package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.FacturaDTO;

import java.util.List;
import java.util.Optional;

public interface IFacturaService {

    public Optional<FacturaDTO> findById(Long id);

    public Optional<List<FacturaDTO>> findByNombre(String nombre);

    public Optional<List<FacturaDTO>> findByCajeroId(Long id);

    public Optional<FacturaDTO> create(FacturaDTO facturaDTO);

    public Optional<FacturaDTO> update(FacturaDTO facturaDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
