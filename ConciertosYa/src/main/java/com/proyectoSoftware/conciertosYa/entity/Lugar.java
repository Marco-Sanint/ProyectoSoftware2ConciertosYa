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
@Table(name = "Lugar")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lugar_id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "ciudad", length = 100)
    private String ciudad;

    @Column(name = "imagen", length = 255)
    private String imagen;
}
