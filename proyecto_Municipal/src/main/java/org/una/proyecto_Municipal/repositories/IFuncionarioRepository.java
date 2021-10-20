package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Funcionario;


import java.util.List;
import java.util.Optional;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public List<Funcionario> findByUsuario(String nombre);

    public List<Funcionario> findByRolId(Long id);

    Optional<Funcionario> findByCedula(String cedula);

    public List<Funcionario> findByEstado(Boolean estado);

//    public Funcionario findByCedulaAndPasswordEncriptado(String cedula, String passwordEncriptado);

//    @Query("select u from Funcionario u where UPPER(u.usuario) like CONCAT('%',UPPER(:usuario),'%')")
//    public Funcionario findNombreWithLikeSQL(@Param("usuario")String usuario);

}
