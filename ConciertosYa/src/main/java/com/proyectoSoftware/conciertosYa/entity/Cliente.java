package com.proyectoSoftware.conciertosYa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    private String cedula;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono", unique = true)
    private String telefono;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @Column(name = "direccion")
    private String direccion;
}
