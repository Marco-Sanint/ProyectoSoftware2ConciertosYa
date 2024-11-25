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
    private Integer id; // ID del carrito item
    private Integer carritoId; // ID del carrito asociado
    private Integer asientoId; // ID del asiento asociado
    private Integer cantidad; // Cantidad de asientos en este ítem
}
