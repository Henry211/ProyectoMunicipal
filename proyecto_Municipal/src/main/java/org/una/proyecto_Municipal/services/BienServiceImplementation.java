package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.BienDTO;
import org.una.proyecto_Municipal.dto.FacturaDTO;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.entities.Bien;
import org.una.proyecto_Municipal.entities.Funcionario;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.repositories.IBienRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class BienServiceImplementation implements IBienService{

    @Autowired
    private IBienRepository bienRepository;

    //findBy...
    @Override
    public Optional<BienDTO> findById(Long id) {
        Optional<Bien> bien = bienRepository.findById(id);
        if (bien.isEmpty()) throw new NotFoundInformationException();

        BienDTO bienDTO = MapperUtils.DtoFromEntity(bien.get(), BienDTO.class);
        return Optional.ofNullable(bienDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<BienDTO>> findAll() {
        List<BienDTO> bienDTOList = MapperUtils.DtoListFromEntityList(bienRepository.findAll(), BienDTO.class);
        return Optional.ofNullable(bienDTOList);
    }

    //get
    private BienDTO getSavedBienDTO(BienDTO bienDTO) {
        Bien bien = MapperUtils.EntityFromDto(bienDTO, Bien.class);
        Bien bienCreated = bienRepository.save(bien);
        return MapperUtils.DtoFromEntity(bienCreated, BienDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<BienDTO> create(BienDTO bienDTO) {
        return Optional.ofNullable(getSavedBienDTO(bienDTO));
    }

    //@Override
    @Transactional
    public Optional<BienDTO> update(BienDTO bienDTO, Long id) {
        if (bienRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedBienDTO(bienDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        bienRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        bienRepository.deleteAll();
    }

}
