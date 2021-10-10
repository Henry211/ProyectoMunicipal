package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LicenciaDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String distrito;
    private boolean estado;
    private Date fecha_registro;
    private Date fecha_modificacion;
    private Double ganancias;
    //private Long bien_id;
}
