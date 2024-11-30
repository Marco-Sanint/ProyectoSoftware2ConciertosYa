package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.entity.Promocion;

public class MapperPromocion {

    public static DtoPromocion mapADtoPromocion(Promocion promocion) {
        return new DtoPromocion(
                promocion.getPromocion_id(),
                promocion.getNombre(),
                promocion.getDescripcion(),
                promocion.getDescuento(),
                promocion.getFechaInicio(),
                promocion.getFechaFin(),
                promocion.getTipo()
        );
    }

    public static Promocion mapAPromocion(DtoPromocion dtoPromocion) {
        return new Promocion(
                dtoPromocion.getPromocion_id(),
                dtoPromocion.getNombre(),
                dtoPromocion.getDescripcion(),
                dtoPromocion.getDescuento(),
                dtoPromocion.getFechaInicio(),
                dtoPromocion.getFechaFin(),
                dtoPromocion.getTipo()
        );
    }
}