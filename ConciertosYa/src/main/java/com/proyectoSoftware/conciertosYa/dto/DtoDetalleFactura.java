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
    private Integer id; // ID del detalle de factura
    private Integer ticketId; // ID del ticket asociado
    private Integer cantidad; // Cantidad de artículos en el detalle
    private double precioUnitario; // Precio unitario de cada artículo
    private double descuento; // Descuento aplicado
    private double precioTotal; // Precio total calculado
}
