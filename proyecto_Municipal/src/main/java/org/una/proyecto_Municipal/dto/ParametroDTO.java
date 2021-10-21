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
public class ParametroDTO {
    private long id;
    private int valor;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
