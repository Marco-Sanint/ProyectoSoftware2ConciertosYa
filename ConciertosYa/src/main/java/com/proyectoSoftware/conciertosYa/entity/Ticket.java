package com.proyectoSoftware.conciertosYa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime fechaCompra;

    @Column(name = "descuento", precision = 10, scale = 2)
    private double descuento;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private double precio;

    @Column(name = "precio_con_descuento", precision = 10, scale = 2)
    private double precioConDescuento;

    @ManyToOne
    @JoinColumn(name = "id_asiento", referencedColumnName = "id", nullable = false)
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;
}
