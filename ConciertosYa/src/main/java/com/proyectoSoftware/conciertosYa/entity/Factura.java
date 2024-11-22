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
@Table(name = "Factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private double total;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id", referencedColumnName = "id")
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @Column(name = "detalles_xml", columnDefinition = "TEXT")
    private String detallesXml;
}
