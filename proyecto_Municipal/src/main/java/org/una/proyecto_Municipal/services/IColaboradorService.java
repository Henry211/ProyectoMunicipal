package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;

import java.util.List;
import java.util.Optional;

public interface IColaboradorService {

    public Optional<ColaboradorDTO> findById(Long id);

    public Optional<List<ColaboradorDTO>> findAll();

    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado);

    public Optional<List<ColaboradorDTO>> findByNombre(String nombre);

    public Optional<List<ColaboradorDTO>> findByCedulaAproximate(String cedula);

    public Optional<List<ColaboradorDTO>> findByTelefono(String telefono);

    public Optional<ColaboradorDTO> create(ColaboradorDTO contribuyenteDTO);

    public Optional<ColaboradorDTO> update(ColaboradorDTO contribuyenteDTO, Long id);

    public void delete(Long id);

    public void deleteAll();


}
