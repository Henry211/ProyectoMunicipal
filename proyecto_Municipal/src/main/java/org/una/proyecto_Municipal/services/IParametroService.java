package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ParametroDTO;

import java.util.List;
import java.util.Optional;

public interface IParametroService{

    public Optional<ParametroDTO> findById(Long id);

    public Optional<List<ParametroDTO>> findByNombre(String nombre);

    public Optional<List<ParametroDTO>> findByEstado(boolean estado);
}
