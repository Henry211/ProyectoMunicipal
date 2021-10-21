package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ColaboradorDTO;

import java.util.List;
import java.util.Optional;

public interface IColaboradorService {

    public Optional<ColaboradorDTO> findById(long id);

    public Optional<List<ColaboradorDTO>> findAll();

    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado);

    public Optional<List<ColaboradorDTO>> findByNombre(String nombre);

    public Optional<List<ColaboradorDTO>> findByCedulaAproximate(String cedula);

    public Optional<List<ColaboradorDTO>> findByTelefono(String telefono);

    public Optional<ColaboradorDTO> create(ColaboradorDTO colaboradorDTO);

    public Optional<ColaboradorDTO> update(ColaboradorDTO colaboradorDTO, long id);

    public void delete(long id);

    public void deleteAll();

}
