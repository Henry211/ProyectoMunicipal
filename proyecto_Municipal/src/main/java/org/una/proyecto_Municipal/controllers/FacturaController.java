package org.una.proyecto_Municipal.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.FacturaDTO;
import org.una.proyecto_Municipal.services.IFacturaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturas")
@Api(tags = {"Facturas"})
public class FacturaController {

    private IFacturaService facturaService;

    @ApiOperation(value = "Obtiene una factura a partir de su id",
            response = CobroDTO.class, tags = "Facturas")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<FacturaDTO> facturaFound = facturaService.findById(id);
        return new ResponseEntity<>(facturaFound, HttpStatus.OK);
    }

//    @ApiOperation(value = "Obtiene una factura a partir del id del cajero",
//            response = CobroDTO.class, tags = "Facturas")
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findByCajeroId(@PathVariable(value = "id") Long id) {
//        Optional<List<FacturaDTO>> facturaFound = facturaService.findByCajeroId(id);
//        return new ResponseEntity<>(facturaFound, HttpStatus.OK);
//    }

    //TODO: create, update, delete, findAll, findByContribuyenteFechaBetween,
    // findByValorImpositvoFechaBetween

}
