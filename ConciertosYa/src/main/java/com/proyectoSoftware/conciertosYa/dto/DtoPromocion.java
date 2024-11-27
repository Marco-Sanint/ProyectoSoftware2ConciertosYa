package com.proyectoSoftware.conciertosYa.dto;

import com.proyectoSoftware.conciertosYa.entity.Promocion;
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

    private Integer promocion_id;
    private String nombre;
    private String descripcion;
    private double descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Promocion.TipoPromocion tipo;
}