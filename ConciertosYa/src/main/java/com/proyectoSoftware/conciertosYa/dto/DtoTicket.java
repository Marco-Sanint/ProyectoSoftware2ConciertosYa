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
public class DtoTicket {
    private Integer id; // ID del ticket
    private LocalDateTime fechaCompra; // Fecha de compra
    private double descuento; // Descuento aplicado
    private double precio; // Precio original
    private double precioConDescuento; // Precio con descuento aplicado
    private Integer asientoId; // ID del asiento asociado
    private String clienteId; // ID del cliente asociado (por cédula)
}
