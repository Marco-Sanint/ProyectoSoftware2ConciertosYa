package com.proyectoSoftware.conciertosYa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCliente {
    private String cedula;
    private String nombre;
    private String telefono;
    private String mail;
    private String direccion;
    private String password;
}
