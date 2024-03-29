package org.una.proyecto_Municipal.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.proyecto_Municipal.dto.*;
import org.una.proyecto_Municipal.exceptions.PasswordIsBlankException;
import org.una.proyecto_Municipal.services.*;
import lombok.SneakyThrows;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    @Value("${spring.security.user.name}")
    private String cedula;

    @Value("${spring.security.user.password}")
    private String password;

    @Autowired
    private IFuncionarioService funcionarioService;

    @Autowired
    private IRolService rolService;

    @Autowired
    private IColaboradorService colaboradorService;

    @Autowired
    private IBienService bienService;

//    @Autowired
//    private IBienxColaboradorService bienxcolaboradorService;

    @Autowired
    private ICobroService cobroService;

    @Autowired
    private IRutaService rutaService;

    @Autowired
    private IDiaSemanaService diasemanaService;

    @Autowired
    private IParametroService parametroService;

    @Autowired
    private ILicenciaService licenciaService;

    @Autowired
    private IDeclaracionAnualService declaracionService;

    @Autowired
    private IPropiedadService propiedadService;

    @Autowired
    private ICalendarioService calendarioService;

    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        if (funcionarioService.findByCedulaAproximate(cedula).isEmpty()) {

            loadFuncionarios();

            loadColaboradores();

            //loadBienes();

            loadParametros();

            loadCobros();

            loadCalendario();

            loadLicencias();

            loadRutas();

            loadPropiedades();

//          TODO:
//            CalendarDTO licenciaCalendario = CalendarDTO.builder()
//                    .monto(10000)
//                    .
//                    .build();
//            calendarioService.create(licenciaCalendario);

            System.out.println("Se agrega el usuario inicial a la aplicación");
        } else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }

    private Date convertStringToDate(String fechaString) throws java.text.ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);
        return date;
    }

    private void loadCalendario() throws ParseException {
        //calendario licencias 2020
        Date d1 = convertStringToDate("2020-03-01");
        Date d2 = convertStringToDate("2020-06-01");
        Date d3 = convertStringToDate("2020-09-01");
        Date d4 = convertStringToDate("2020-12-01");
        CalendarioDTO calendarioLicencias2020 = CalendarioDTO.builder()
                .id(Long.valueOf(1))
                .tipo(1)
                .periodo(6)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .anio(2020)
                .build();
        calendarioService.create(calendarioLicencias2020);

        //calendario licencias 2021
        d1 = convertStringToDate("2021-03-01");
        d2 = convertStringToDate("2021-06-01");
        d3 = convertStringToDate("2021-09-01");
        d4 = convertStringToDate("2021-12-01");
        CalendarioDTO calendarioLicencias2021 = CalendarioDTO.builder()
                .id(Long.valueOf(2))
                .tipo(1)
                .periodo(6)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .anio(2021)
                .build();
        calendarioService.create(calendarioLicencias2021);

        //calendario licencias 2022
        d1 = convertStringToDate("2022-03-01");
        d2 = convertStringToDate("2022-06-01");
        d3 = convertStringToDate("2022-09-01");
        d4 = convertStringToDate("2022-12-01");
        CalendarioDTO calendarioLicencias2022 = CalendarioDTO.builder()
                .id(Long.valueOf(3))
                .tipo(1)
                .periodo(6)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .anio(2022)
                .build();
        calendarioService.create(calendarioLicencias2022);

        //calendario limpieza de vías 2020
        d1 = convertStringToDate("2020-02-01");
        d2 = convertStringToDate("2020-04-01");
        d3 = convertStringToDate("2020-06-01");
        d4 = convertStringToDate("2020-08-01");
        Date d5 = convertStringToDate("2020-10-01");
        Date d6 = convertStringToDate("2020-12-01");
        CalendarioDTO calendarioLimpieza2020 = CalendarioDTO.builder()
                .id(Long.valueOf(4))
                .tipo(2)
                .periodo(4)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .fecha6(d6)
                .anio(2020)
                .build();
        calendarioService.create(calendarioLimpieza2020);

        //calendario limpieza de vías 2021
        d1 = convertStringToDate("2021-02-01");
        d2 = convertStringToDate("2021-04-01");
        d3 = convertStringToDate("2021-06-01");
        d4 = convertStringToDate("2021-08-01");
        d5 = convertStringToDate("2021-10-01");
        d6 = convertStringToDate("2021-12-01");
        CalendarioDTO calendarioLimpieza2021 = CalendarioDTO.builder()
                .id(Long.valueOf(5))
                .tipo(2)
                .periodo(4)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .fecha6(d6)
                .anio(2021)
                .build();
        calendarioService.create(calendarioLimpieza2021);

        //calendario limpieza de vías 2022
        d1 = convertStringToDate("2022-02-01");
        d2 = convertStringToDate("2022-04-01");
        d3 = convertStringToDate("2022-06-01");
        d4 = convertStringToDate("2022-08-01");
        d5 = convertStringToDate("2022-10-01");
        d6 = convertStringToDate("2022-12-01");
        CalendarioDTO calendarioLimpieza2022 = CalendarioDTO.builder()
                .id(Long.valueOf(6))
                .tipo(2)
                .periodo(4)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .fecha6(d6)
                .anio(2022)
                .build();
        calendarioService.create(calendarioLimpieza2022);

        //calendario rutas 2020
        d1 = convertStringToDate("2020-01-01");
        d2 = convertStringToDate("2020-02-01");
        d3 = convertStringToDate("2020-03-01");
        d4 = convertStringToDate("2020-04-01");
        d5 = convertStringToDate("2020-05-01");
        d6 = convertStringToDate("2020-06-01");
        Date d7 = convertStringToDate("2020-07-01");
        Date d8 = convertStringToDate("2020-08-01");
        Date d9 = convertStringToDate("2020-09-01");
        Date d10 = convertStringToDate("2020-10-01");
        Date d11 = convertStringToDate("2020-11-01");
        Date d12 = convertStringToDate("2020-12-01");

        CalendarioDTO calendarioRutas2020 = CalendarioDTO.builder()
                .id(Long.valueOf(7))
                .tipo(3)
                .periodo(12)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .fecha6(d6)
                .fecha7(d7)
                .fecha8(d8)
                .fecha9(d9)
                .fecha10(d10)
                .fecha11(d11)
                .fecha12(d12)
                .anio(2020)
                .build();
        calendarioService.create(calendarioRutas2020);

        //calendario rutas 2021
        d1 = convertStringToDate("2021-01-01");
        d2 = convertStringToDate("2021-02-01");
        d3 = convertStringToDate("2021-03-01");
        d4 = convertStringToDate("2021-04-01");
        d5 = convertStringToDate("2021-05-01");
        d6 = convertStringToDate("2021-06-01");
        d7 = convertStringToDate("2021-07-01");
        d8 = convertStringToDate("2021-08-01");
        d9 = convertStringToDate("2021-09-01");
        d10 = convertStringToDate("2021-10-01");
        d11 = convertStringToDate("2021-11-01");
        d12 = convertStringToDate("2021-12-01");

        CalendarioDTO calendarioRutas2021 = CalendarioDTO.builder()
                .id(Long.valueOf(8))
                .tipo(3)
                .periodo(12)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .fecha6(d6)
                .fecha7(d7)
                .fecha8(d8)
                .fecha9(d9)
                .fecha10(d10)
                .fecha11(d11)
                .fecha12(d12)
                .anio(2021)
                .build();
        calendarioService.create(calendarioRutas2021);

        //calendario rutas 2022
        d1 = convertStringToDate("2022-01-01");
        d2 = convertStringToDate("2022-02-01");
        d3 = convertStringToDate("2022-03-01");
        d4 = convertStringToDate("2022-04-01");
        d5 = convertStringToDate("2022-05-01");
        d6 = convertStringToDate("2022-06-01");
        d7 = convertStringToDate("2022-07-01");
        d8 = convertStringToDate("2022-08-01");
        d9 = convertStringToDate("2022-09-01");
        d10 = convertStringToDate("2022-10-01");
        d11 = convertStringToDate("2022-11-01");
        d12 = convertStringToDate("2022-12-01");

        CalendarioDTO calendarioRutas2022 = CalendarioDTO.builder()
                .id(Long.valueOf(9))
                .tipo(3)
                .periodo(12)
                .fecha1(d1)
                .fecha2(d2)
                .fecha3(d3)
                .fecha4(d4)
                .fecha5(d5)
                .fecha6(d6)
                .fecha7(d7)
                .fecha8(d8)
                .fecha9(d9)
                .fecha10(d10)
                .fecha11(d11)
                .fecha12(d12)
                .anio(2022)
                .build();
        calendarioService.create(calendarioRutas2022);
    }

    private void loadCobros() {
        //cobros
        CobroDTO cobro = CobroDTO.builder()
                .estado(true)
                .monto(50000)
                .tipo(1) //1. licencias 2. propiedades 3. rutas
                .periodo(3)
                .build();
        cobroService.create(cobro,Long.valueOf(1));

        CobroDTO cobro1 = CobroDTO.builder()
                .estado(false)
                .monto(40000)
                .tipo(3)
                .periodo(1)
                .build();
        cobroService.create(cobro1,Long.valueOf(1));

        CobroDTO cobro2 = CobroDTO.builder()
                .estado(true)
                .monto(35000)
                .tipo(2)
                .periodo(2)
                .build();
        cobroService.create(cobro2,Long.valueOf(1));

        CobroDTO cobro3 = CobroDTO.builder()
                .estado(false)
                .monto(45000)
                .tipo(3)
                .periodo(1)
                .build();
        cobroService.create(cobro3,Long.valueOf(1));
    }

    private void loadRutas(){
        //rutas
        RutaDTO ruta = RutaDTO.builder()
                .estado(true)
                //.bienId(bien)
                .nombreRuta("PZ - SJ")
                .finalRuta("fin")
                .inicioRuta("ini")
                .build();
        rutaService.create(ruta);

        //dias semana
        DiaSemanaDTO dia = DiaSemanaDTO.builder()
                .cantidadSalidas(5)
                .nombreDia("lunes")
                .build();
        diasemanaService.create(dia);

        DiaSemanaDTO dia1 = DiaSemanaDTO.builder()
                .cantidadSalidas(9)
                .nombreDia("martes")
                .build();
        diasemanaService.create(dia1);

        DiaSemanaDTO dia2 = DiaSemanaDTO.builder()
                .cantidadSalidas(6)
                .nombreDia("miércoles")
                .build();
        diasemanaService.create(dia2);

        DiaSemanaDTO dia3 = DiaSemanaDTO.builder()
                .cantidadSalidas(7)
                .nombreDia("jueves")
                .build();
        diasemanaService.create(dia3);

        DiaSemanaDTO dia4 = DiaSemanaDTO.builder()
                .cantidadSalidas(10)
                .nombreDia("viernes")
                .build();
        diasemanaService.create(dia4);
    }

    private void loadPropiedades(){
        //propiedades
        PropiedadDTO propiedad = PropiedadDTO.builder()
                .canton("Pérez Zeledón")
                .direccion("Barrio ...")
                .distrito("San Isidro")
                .esEstado(true)
                .estado(true)
                .provincia("San José")
                .zona(1)
                .build();
        propiedadService.create(propiedad);

        PropiedadDTO propiedad2 = PropiedadDTO.builder()
                .canton("Pérez Zeledón")
                .direccion("Barrio ...")
                .distrito("San Isidro")
                .esEstado(true)
                .estado(true)
                .provincia("San José")
                .zona(2)
                .build();
        propiedadService.create(propiedad2);
    }

    private void loadLicencias(){
        //bienes
        BienDTO bien = BienDTO.builder().build();
        bienService.create(bien,Long.valueOf(1));

        BienDTO bien1 = BienDTO.builder().build();
        bienService.create(bien1,Long.valueOf(1));

        BienDTO bien2 = BienDTO.builder().build();
        bienService.create(bien2,Long.valueOf(1));

        LicenciaDTO licencia = LicenciaDTO.builder().bienId(bien2)
                .distrito("San Isidro")
                .email("licenacia1@gmail.com")
                .estado(true)
                .ganancias(300000)
                .nombre("licencia1")
                .telefono("12345678")
                .bienId(bien)
                .build();
        licenciaService.create(licencia);

        LicenciaDTO licencia2 = LicenciaDTO.builder().bienId(bien)
                .distrito("San Isidro")
                .email("licencia2@gmail.com")
                .estado(true)
                .ganancias(500000)
                .nombre("licencia2")
                .telefono("87654321")
                .bienId(bien2)
                .build();
        licenciaService.create(licencia2);

        //declaraciones anules
        DeclaracionAnualDTO declaracion = DeclaracionAnualDTO.builder()
                .anio(2019)
                .montoAnual(1000000)
                .build();
        declaracionService.create(declaracion);

        DeclaracionAnualDTO declaracion1 = DeclaracionAnualDTO.builder()
                .anio(2020)
                .montoAnual(2000000)
                .build();
        declaracionService.create(declaracion1);
    }

    private void loadFuncionarios() throws PasswordIsBlankException {

        //Optional<RolDTO> colaboradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_COLABORADOR.name()).build());
        Optional<RolDTO> auditorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_AUDITOR.name()).build());
        Optional<RolDTO> gestorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GESTOR.name()).build());
        Optional<RolDTO> administradorRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_ADMINISTRADOR.name()).build());
        Optional<RolDTO> gerenteRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_GERENTE.name()).build());
        Optional<RolDTO> botRol = rolService.create(RolDTO.builder().nombre(RolesTypes.ROLE_BOT.name()).build());

        FuncionarioDTO gestorUsuario = FuncionarioDTO.builder()
                .cedula("01x34z37y68ñ25")
                .usuario("Data Loader")
                .passwordEncriptado("Una2021")
                .rol(gestorRol.orElseThrow()).build();
        funcionarioService.create(gestorUsuario,Long.valueOf(1));

        FuncionarioDTO administradorUsuario = FuncionarioDTO.builder()
                .cedula(cedula)
                .usuario("Usuario Administrador")
                .passwordEncriptado(password)
                .rol(administradorRol.orElseThrow()).build();
        funcionarioService.create(administradorUsuario,Long.valueOf(1));

        FuncionarioDTO botUsuario = FuncionarioDTO.builder()
                .cedula("roboto")
                .usuario("Usuario Bot")
                .passwordEncriptado("botcito")
                .rol(botRol.orElseThrow()).build();
        funcionarioService.create(botUsuario,Long.valueOf(1));

        FuncionarioDTO gerenteUsuario = FuncionarioDTO.builder()
                .cedula("2211")
                .usuario("Usuario Gerente")
                .passwordEncriptado("gerencia")
                .rol(gerenteRol.orElseThrow()).build();
        funcionarioService.create(gerenteUsuario,Long.valueOf(1));

        FuncionarioDTO auditorUsuario = FuncionarioDTO.builder()
                .cedula("8801")
                .usuario("Usuario Auditor")
                .passwordEncriptado("auditoría")
                .rol(auditorRol.orElseThrow()).build();
        funcionarioService.create(auditorUsuario,Long.valueOf(1));
    }

    private void loadColaboradores() throws ParseException {
        //colaboradores
        ColaboradorDTO colaborador = ColaboradorDTO.builder()
                .cedula("116380047")
                .nombre("Andrey")
                .telefono("89417655")
                .build();
        colaboradorService.create(colaborador,Long.valueOf(1));

        ColaboradorDTO colaborador1 = ColaboradorDTO.builder()
                .cedula("117940673")
                .nombre("Danah")
                .telefono("61519481")
                .build();
        colaboradorService.create(colaborador1,Long.valueOf(1));

        ColaboradorDTO colaborador2 = ColaboradorDTO.builder()
                .cedula("116950926")
                .nombre("Henry")
                .telefono("83594798")
                .build();
        colaboradorService.create(colaborador2,Long.valueOf(1));
    }

    private void loadParametros() throws ParseException {
        //parametros
        ParametroDTO horario1 = ParametroDTO.builder()
                .descripcion("Lunes a Viernes de 8:00 am a 5:00 pm")
                .estado(true)
                .nombre("horario")
                .valor(2)
                .build();
        parametroService.create(horario1,Long.valueOf(1));

        ParametroDTO horario2 = ParametroDTO.builder()
                .descripcion("Sabado de 8:00 am a 12:00 md")
                .estado(true)
                .nombre("horario")
                .valor(2)
                .build();
        parametroService.create(horario2,Long.valueOf(1));

        ParametroDTO formula1 = ParametroDTO.builder()
                .descripcion("Formula licencias comerciales -> Tarifa trimestral = Ganancias brutas * 0,2 (minimo de 40 000 colones)")
                .estado(true)
                .nombre("formula")
                .valor(1)
                .build();
        parametroService.create(formula1,Long.valueOf(1));

        ParametroDTO formula2 = ParametroDTO.builder()
                .descripcion("Formula limpieza de vías -> Tarifa bimestral = metros de frente / 1500 (mínimo de 8 metros a cobrar y un máximo de 35)")
                .estado(true)
                .nombre("formula")
                .valor(1)
                .build();
        parametroService.create(formula2,Long.valueOf(1));

        ParametroDTO formula3 = ParametroDTO.builder()
                .descripcion("Formula rutas de buses -> Tarifa mensual = cantidad de salidas diarias * 200")
                .estado(true)
                .nombre("formula")
                .valor(1)
                .build();
        parametroService.create(formula3,Long.valueOf(1));

        ParametroDTO help1 = ParametroDTO.builder()
                .descripcion("/horario Devuelve el horario de la empresa")
                .estado(true)
                .nombre("help")
                .valor(3)
                .build();
        parametroService.create(help1,Long.valueOf(1));

        ParametroDTO help2 = ParametroDTO.builder()
                .descripcion("/formulas Devuelve las formulas de calculo de impuestos")
                .estado(true)
                .nombre("help")
                .valor(3)
                .build();
        parametroService.create(help2,Long.valueOf(1));

        ParametroDTO help3 = ParametroDTO.builder()
                .descripcion("/pendiente cedula Devuelve los pendientes asociados a una cedula")
                .estado(true)
                .nombre("help")
                .valor(3)
                .build();
        parametroService.create(help3,Long.valueOf(1));

        ParametroDTO help4 = ParametroDTO.builder()
                .descripcion("/pagos cedula fecha inicio fecha final Devuelve los pagos asociados a una cedula entre un rango de fechas")
                .estado(true)
                .nombre("help")
                .valor(3)
                .build();
        parametroService.create(help4,Long.valueOf(1));

        ParametroDTO help5 = ParametroDTO.builder()
                .descripcion("/impuesto cedula tipo de impuesto (1. Licencias comerciales 2. Limpieza de vías 3. Rutas de buses) Devuelve los pendientes asociados a una cedula según un tipo de impuesto")
                .estado(true)
                .nombre("help")
                .valor(3)
                .build();
        parametroService.create(help5,Long.valueOf(1));

        //--------------------------
        //---Variables 'valores'----
        //--------------------------

        ParametroDTO periodoCobroLicencia = ParametroDTO.builder()
                .descripcion("cantidad de meses por los que se cobra")
                .estado(true)
                .nombre("PeriodoCobroLicencia")
                .valor(4)
                .build();
        parametroService.create(periodoCobroLicencia,Long.valueOf(1));

        ParametroDTO montoMinimoLicencia = ParametroDTO.builder()
                .descripcion("monto mínimo a cobrar por el servicio de licencia")
                .estado(true)
                .nombre("MontoMinimoLicencia")
                .valor(4)
                .build();
        parametroService.create(montoMinimoLicencia,Long.valueOf(1));

        ParametroDTO porcentajeSobreGananciaBrutaLicencia = ParametroDTO.builder()
                .descripcion("porcentaje sobre ganancias brutas que se va a cobrar")
                .estado(true)
                .nombre("PorcentajeSobreGananciasBrutasLicencia")
                .valor(4)
                .build();
        parametroService.create(porcentajeSobreGananciaBrutaLicencia,Long.valueOf(1));

        ParametroDTO costoTimbre = ParametroDTO.builder()
                .descripcion("costo del timbre")
                .estado(true)
                .nombre("CostoTimbre")
                .valor(4)
                .build();
        parametroService.create(costoTimbre,Long.valueOf(1));

        ParametroDTO periodoCobroLimpieza = ParametroDTO.builder()
                .descripcion("cantidad de meses por los que se cobra")
                .estado(true)
                .nombre("PeriodoCobroLimpieza")
                .valor(4)
                .build();
        parametroService.create(periodoCobroLimpieza,Long.valueOf(1));

        ParametroDTO montoPorMetroFrenteLimpieza = ParametroDTO.builder()
                .descripcion("monto a cobrar por cada metro de frente en la propiedad")
                .estado(true)
                .nombre("montoPorMetroFrenteLimpieza")
                .valor(4)
                .build();
        parametroService.create(montoPorMetroFrenteLimpieza,Long.valueOf(1));

        ParametroDTO maximoMetrosLimpieza = ParametroDTO.builder()
                .descripcion("cantidad máxima de metros de frente a considerar")
                .estado(true)
                .nombre("maximoMetrosLimpieza")
                .valor(4)
                .build();
        parametroService.create(maximoMetrosLimpieza,Long.valueOf(1));

        ParametroDTO minimoMetrosLimpieza = ParametroDTO.builder()
                .descripcion("cantidad minima de metros de frente a considerar")
                .estado(true)
                .nombre("minimoMetrosLimpieza")
                .valor(4)
                .build();
        parametroService.create(minimoMetrosLimpieza,Long.valueOf(1));

        ParametroDTO periodoCobroBuses = ParametroDTO.builder()
                .descripcion("cantidad de meses por los que se cobra")
                .estado(true)
                .nombre("PeriodoCobroBuses")
                .valor(4)
                .build();
        parametroService.create(periodoCobroBuses,Long.valueOf(1));

        ParametroDTO salidaPorDiaBuses = ParametroDTO.builder()
                .descripcion("cantidad de salidas por dia")
                .estado(true)
                .nombre("salidaPorDiaBuses")
                .valor(4)
                .build();
        parametroService.create(salidaPorDiaBuses,Long.valueOf(1));
    }

}
