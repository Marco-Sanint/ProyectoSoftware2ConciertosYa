package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoDetalleFactura {
    private Integer detalleFacturaId;
    private Integer cantidad;
    private double precioUnitario;
    private double descuento;
    private double precioTotal;
    private Integer ticketId; // ID del ticket
}