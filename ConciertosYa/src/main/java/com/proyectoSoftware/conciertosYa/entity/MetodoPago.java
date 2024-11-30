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
@Table(name = "Metodo_Pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer metodo_pago_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoMetodoPago tipo;

    public enum TipoMetodoPago {
        EFECTIVO,
        EFECTIVO_Y_TARJETA_DE_CREDITO,
        EFECTIVO_Y_TARJETA_DE_CREDITO_CONCIERTOSYA,
        TARJETA_DE_CREDITO_Y_TARJETA_CONCIERTOSYA
    }
}