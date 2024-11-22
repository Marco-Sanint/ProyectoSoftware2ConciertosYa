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
@Table(name = "Asientos")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo", nullable = false, unique = true, length = 50)
    private String codigo;

    @Column(name = "columna", nullable = false)
    private String columna;

    @Column(name = "precio", nullable = false, precision = 10)
    private double precio;

    @Column(name = "descuento", nullable = false, precision = 10)
    private double descuento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoAsiento tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoAsiento estado;

    // Lista de opciones para el tipo de silla
    public enum TipoAsiento {
        General, VIP, Palco
    }

    // Lista de opciones para el estado de la silla
    public enum EstadoAsiento {
        Vendido, Disponible, Reservado
    }
}
