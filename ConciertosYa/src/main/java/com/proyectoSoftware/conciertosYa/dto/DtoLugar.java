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
    private Integer id;          // ID del lugar
    private String nombre;       // Nombre del lugar
    private String direccion;    // Dirección del lugar
    private Integer capacidad;   // Capacidad del lugar
    private String ciudad;       // Ciudad del lugar
    private String imagen;       // URL de la imagen del lugar
}
