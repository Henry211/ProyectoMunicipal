package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.proyecto_Municipal.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IColaboradorRepository extends JpaRepository<Colaborador, Long> {

    public List<Colaborador> findByNombre(String nombre);

    public List<Colaborador> findByTelefono(String telefono);

    public List<Colaborador> findByEstado(boolean estado);

    public List<Colaborador> findByCedulaContaining(String cedula);

    @Query(value = "{call saveTransaction(:accion_in, :objeto_in, :funId_in, :date_in)}", nativeQuery=true)
    public String saveTransaction(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") String funId_in,
            @Param("date_in") Date date_in
    );

    @Query(value = "{call registrarTransaccion(:accion_in, :objeto_in, :funId_in, :parametro_in)}", nativeQuery=true)
    public void registrarTransaccion(
            @Param("accion_in") String accion_in,
            @Param("objeto_in") String objeto_in,
            @Param("funId_in") Long funId_in,
            @Param("parametro_in") String parametro_in
    );

//  TODO: find Colaboradores by CobroId, BienId

}
