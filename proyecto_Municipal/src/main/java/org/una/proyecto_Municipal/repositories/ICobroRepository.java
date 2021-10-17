package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.entities.Rol;

import java.util.List;

public interface ICobroRepository extends JpaRepository<Cobro, Long> {

    public List<Cobro> findByEstado(Boolean estado);

//    public List<Cobro>  findByBienId(Long id);

//    public List<Cobro>  findByColaboradores(Long id);

    public List<Cobro>  findByFacturaId(Long id);
}
