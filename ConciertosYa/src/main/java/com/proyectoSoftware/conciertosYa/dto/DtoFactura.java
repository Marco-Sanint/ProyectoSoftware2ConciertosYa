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
    private Integer id;               // ID de la factura
    private LocalDateTime fechaEmision; // Fecha de emisión de la factura
    private double total;             // Total de la factura
    private Integer metodoPagoId;     // ID del método de pago
    private Integer clienteId;        // ID del cliente
    private String detallesXml;       // Detalles en formato XML
}
