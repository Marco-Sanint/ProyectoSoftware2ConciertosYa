package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoMetodoPago {
    private Integer id; // ID del método de pago
    private String tipo; // Tipo de método de pago (enum como cadena)
}
