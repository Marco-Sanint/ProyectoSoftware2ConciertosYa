package com.proyectoSoftware.conciertosYa.dto;

import com.proyectoSoftware.conciertosYa.entity.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoMetodoPago {

    private Integer metodo_pago_id;
    private MetodoPago.TipoMetodoPago tipo;
}