package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.entities.Ruta;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IRutaRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class RutaServiceImplementation implements IRutaService{

    @Autowired
    private IRutaRepository rutaRepository;

    //findBy...
    @Override
    public Optional<RutaDTO> findById(long id) {
        Optional<Ruta> ruta = rutaRepository.findById(id);
        if (ruta.isEmpty()) throw new NotFoundInformationException();

        RutaDTO rutaDTO = MapperUtils.DtoFromEntity(ruta.get(), RutaDTO.class);
        return Optional.ofNullable(rutaDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<RutaDTO>> findAll() {
        List<RutaDTO> rutaDTOList = MapperUtils.DtoListFromEntityList(rutaRepository.findAll(), RutaDTO.class);
        return Optional.ofNullable(rutaDTOList);
    }

    @Override
    public Optional<List<RutaDTO>> findByEstado(boolean estado) {
        List<Ruta> rutaList = rutaRepository.findByEstado(estado);
        List<RutaDTO> rutaDTOList = MapperUtils.DtoListFromEntityList(rutaList, RutaDTO.class);
        return Optional.ofNullable(rutaDTOList);
    }

    @Override
    public Optional<List<RutaDTO>> findByBienId(long id) {
        List<RutaDTO> rutaDTOList = MapperUtils.DtoListFromEntityList(rutaRepository.findByBienId(id), RutaDTO.class);
        if (rutaDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(rutaDTOList);
    }

    //delete
    @Override
    @Transactional
    public void delete(long id) {
        rutaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        rutaRepository.deleteAll();
    }

    //get
    private RutaDTO getSavedRutaDTO(RutaDTO rutaDTO) {
        Ruta ruta = MapperUtils.EntityFromDto(rutaDTO, Ruta.class);
        Ruta rutaCreated = rutaRepository.save(ruta);
        return MapperUtils.DtoFromEntity(rutaCreated , RutaDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<RutaDTO> create(RutaDTO rutaDTO) {
        return Optional.ofNullable(getSavedRutaDTO(rutaDTO));
    }

    @Override
    @Transactional
    public Optional<RutaDTO> update(RutaDTO rutaDTO, long id) {
        if (rutaRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedRutaDTO(rutaDTO));

    }

}
