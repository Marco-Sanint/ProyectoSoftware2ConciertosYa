package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCarritoItem {
    private Integer carritoItemId;
    private Integer carritoId; // ID del carrito
    private Integer asientoId; // ID del asiento
    private Integer cantidad;
}