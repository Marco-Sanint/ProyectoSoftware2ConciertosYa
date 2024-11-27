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
    private Integer ticketId;
    private LocalDateTime fechaCompra;
    private double descuento;
    private double precio;
    private double precioConDescuento;
    private Integer asientoId; // ID del asiento
    private String clienteCedula; // Cédula del cliente
}