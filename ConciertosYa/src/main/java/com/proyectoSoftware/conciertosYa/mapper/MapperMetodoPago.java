package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;
import com.proyectoSoftware.conciertosYa.entity.MetodoPago;

public class MapperMetodoPago {

    public static DtoMetodoPago mapADtoMetodoPago(MetodoPago metodoPago) {
        return new DtoMetodoPago(
                metodoPago.getId(),
                metodoPago.getTipo().name()
        );
    }

    public static MetodoPago mapAMetodoPago(DtoMetodoPago dtoMetodoPago) {
        return new MetodoPago(
                dtoMetodoPago.getId(),
                MetodoPago.TipoMetodoPago.valueOf(dtoMetodoPago.getTipo())
        );
    }
}
