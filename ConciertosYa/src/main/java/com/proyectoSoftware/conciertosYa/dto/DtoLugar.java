package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoLugar {

    private Integer lugar_id;
    private String nombre;
    private String direccion;
    private Integer capacidad;
    private String ciudad;
    private String imagen;
}