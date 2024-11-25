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
    private Integer id; // ID del carrito
    private String clienteCedula; // Cedula del cliente relacionado
    private LocalDateTime fechaCreacion; // Fecha de creación del carrito
}

