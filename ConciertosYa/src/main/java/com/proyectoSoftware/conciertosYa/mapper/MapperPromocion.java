package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.entity.Promocion;

public class MapperPromocion {

    public static DtoPromocion mapADtoPromocion(Promocion promocion) {
        return new DtoPromocion(
                promocion.getId(),
                promocion.getNombre(),
                promocion.getDescripcion(),
                promocion.getDescuento(),
                promocion.getFechaInicio(),
                promocion.getFechaFin(),
                promocion.getTipo().name()
        );
    }

    public static Promocion mapAPromocion(DtoPromocion dtoPromocion) {
        return new Promocion(
                dtoPromocion.getId(),
                dtoPromocion.getNombre(),
                dtoPromocion.getDescripcion(),
                dtoPromocion.getDescuento(),
                dtoPromocion.getFechaInicio(),
                dtoPromocion.getFechaFin(),
                Promocion.TipoPromocion.valueOf(dtoPromocion.getTipo())
        );
    }
}
