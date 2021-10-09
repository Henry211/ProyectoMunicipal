package org.una.proyecto_Municipal.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Component
public class InformationNotSavedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus errorCode = HttpStatus.NOT_ACCEPTABLE;

    private final String errorMessage = "Ocurrió un error al guardar la información";
}