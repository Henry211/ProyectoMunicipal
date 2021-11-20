package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Licencia;

import java.util.List;

public interface ILicenciaRepository extends JpaRepository<Licencia, Long> {

    public List<Licencia> findByNombre(String nombre);

    public Licencia findByTelefono(String telefono);

    public Licencia findByEmail(String email);

    public List<Licencia> findByDistrito(String distrito);

    public List<Licencia> findByEstado(boolean estado);

    @Query(value = "{call registrarTransaccion(:accion_in, :objeto_in, :funId_in, :parametro_in)}", nativeQuery=true)
    public void registrarTransaccion(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") Long funId_in,
            @Param("parametro_in") String parametro_in
    );

    //public List<Licencia>  findByBienId(Long id);

}