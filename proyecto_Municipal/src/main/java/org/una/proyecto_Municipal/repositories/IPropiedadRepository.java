package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Propiedad;

import java.util.List;

public interface IPropiedadRepository extends JpaRepository<Propiedad, Long> {

//    public List<Propiedad> findByNombre(String nombre);

    public List<Propiedad> findByProvincia(String provincia);

    public List<Propiedad> findByEstado(boolean estado);

    @Query(value = "{call registrarTransaccion(:accion_in, :objeto_in, :funId_in, :parametro_in)}", nativeQuery=true)
    public void registrarTransaccion(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") Long funId_in,
            @Param("parametro_in") String parametro_in
    );
}