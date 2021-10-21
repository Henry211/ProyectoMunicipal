package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ParametroDTO {
    private Long id;
    private int valor;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
