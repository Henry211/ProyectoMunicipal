package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CobroDTO {
    private Long id;
    private double monto;
    private boolean estado;
    private Integer periodo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private BienxColaboradorDTO bienxColaboradorId;
    private FacturaDTO facturaId;
}
