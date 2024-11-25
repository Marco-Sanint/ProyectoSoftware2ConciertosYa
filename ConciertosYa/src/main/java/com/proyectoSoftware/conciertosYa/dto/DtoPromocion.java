package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoPromocion {
    private Integer id; // ID de la promoción
    private String nombre; // Nombre de la promoción
    private String descripcion; // Descripción de la promoción
    private double descuento; // Descuento aplicado
    private LocalDate fechaInicio; // Fecha de inicio
    private LocalDate fechaFin; // Fecha de fin
    private String tipo; // Tipo de promoción (GENERAL, VIP, CONCIERTOSYA)
}
