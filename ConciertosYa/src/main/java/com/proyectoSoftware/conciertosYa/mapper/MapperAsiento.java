package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import com.proyectoSoftware.conciertosYa.entity.Asiento;

public class MapperAsiento {

    public static DtoAsiento mapADtoAsiento(Asiento asiento){
        return new DtoAsiento(
                asiento.getId(),
                asiento.getCodigo(),
                asiento.getColumna(),
                asiento.getPrecio(),
                asiento.getDescuento(),
                asiento.getTipo(),
                asiento.getEstado()
        );
    }

    public static Asiento mapAAsiento(DtoAsiento dtoAsiento){
        return new Asiento(
                dtoAsiento.getId(),
                dtoAsiento.getCodigo(),
                dtoAsiento.getColumna(),
                dtoAsiento.getPrecio(),
                dtoAsiento.getDescuento(),
                dtoAsiento.getTipo(),
                dtoAsiento.getEstado()
        );
    }
}
