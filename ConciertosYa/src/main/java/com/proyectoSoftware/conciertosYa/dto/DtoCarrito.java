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
public class DtoCarrito {
    private Integer carritoId;
    private String cedulaCliente; // ID del cliente (cedula)
    private LocalDateTime fechaCreacion;
}