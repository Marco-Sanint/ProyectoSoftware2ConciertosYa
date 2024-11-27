package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoFactura {

    private Integer factura_id;
    private LocalDateTime fechaEmision;
    private double total;
    private Integer metodoPagoId; // ID del método de pago
    private String clienteCedula; // Cédula del cliente
    private String detallesXml;
}