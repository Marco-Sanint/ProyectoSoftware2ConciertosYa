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

    private int lugar_id;
    private String nombre;
    private String direccion;
    private int capacidad;
    private String ciudad;
    private String imagen;
}