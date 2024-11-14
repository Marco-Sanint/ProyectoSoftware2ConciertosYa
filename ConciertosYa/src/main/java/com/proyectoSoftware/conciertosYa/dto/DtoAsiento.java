package com.proyectoSoftware.conciertosYa.dto;

import com.proyectoSoftware.conciertosYa.entity.Asiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoAsiento {

    private int asiento_id;
    private String codigo;
    private String columna;
    private double precio;
    private double descuento;
    private Asiento.TipoAsiento tipo;
    private Asiento.EstadoAsiento estado;
}