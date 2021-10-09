package org.una.proyecto_Municipal.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.services.IFuncionarioService;
import org.una.proyecto_Municipal.services.IRolService;
/*import org.una.Proyecto_Municipal.dto.DepartamentoDTO;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.IDepartamentoService;
import org.una.inventario.services.IRolService;
import org.una.inventario.services.IUsuarioService;*/

import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    @Value("admin")
    private String cedula;

    @Value("Una2021")
    private String password;

    @Autowired
    private IFuncionarioService funcionarioService;

    @Autowired
    private IRolService rolService;


    @Override
    public void run(ApplicationArguments args) {
        if (funcionarioService.findByCedulaAproximate(cedula).isEmpty()) {

            Optional<RolDTO> colaboradorRol = rolService.create(RolDTO.builder().nombre("Colaborador").build());
            Optional<RolDTO> auditorRol = rolService.create(RolDTO.builder().nombre("Auditor").build());
            Optional<RolDTO> contadorRol = rolService.create(RolDTO.builder().nombre("Contador").build());
            Optional<RolDTO> usuarioRol = rolService.create(RolDTO.builder().nombre("Usuario").build());
            Optional<RolDTO> administradorRol = rolService.create(RolDTO.builder().nombre("Administrador").build());


            FuncionarioDTO cajeroUsuario = FuncionarioDTO.builder()
                    .cedula("0123456789")
                    .usuario("Usuario Prueba Cajero")
                    .passwordEncriptado("Una2021")
                    .rol(usuarioRol.orElseThrow()).build();
            funcionarioService.create(cajeroUsuario);

            FuncionarioDTO contadorUsuario = FuncionarioDTO.builder()
                    .cedula("9876543210")
                    .usuario("Usuario Prueba Contador")
                    .passwordEncriptado("Una2021")
                    .rol(contadorRol.orElseThrow()).build();
            funcionarioService.create(contadorUsuario);

            FuncionarioDTO administradorUsuario = FuncionarioDTO.builder()
                    .cedula(cedula)
                    .usuario("Usuario Administrador")
                    .passwordEncriptado(password)
                    .rol(administradorRol.orElseThrow()).build();
            funcionarioService.create(administradorUsuario);

            System.out.println("Se agrega el usuario inicial a la aplicación");
        }else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }

}
