package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.Licencia;
import org.una.proyecto_Municipal.entities.Propiedad;
import org.una.proyecto_Municipal.entities.Ruta;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BienDTO {
    private Long id;
    //private List<BienxColaboradorDTO> bienesxColaborador;
//    private ColaboradorDTO colaborador;
    private PropiedadDTO propiedad;
    private LicenciaDTO licencia;
    private RutaDTO ruta;
}
