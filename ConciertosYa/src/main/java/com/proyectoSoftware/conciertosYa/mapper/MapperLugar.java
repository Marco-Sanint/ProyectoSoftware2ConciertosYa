package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.entity.Lugar;

public class MapperLugar {

    public static DtoLugar mapADtoLugar(Lugar lugar) {
        return new DtoLugar(
                lugar.getLugar_id(),
                lugar.getNombre(),
                lugar.getDireccion(),
                lugar.getCapacidad(),
                lugar.getCiudad(),
                lugar.getImagen()
        );
    }

    public static Lugar mapALugar(DtoLugar dtoLugar) {
        return new Lugar(
                dtoLugar.getLugar_id(),
                dtoLugar.getNombre(),
                dtoLugar.getDireccion(),
                dtoLugar.getCapacidad(),
                dtoLugar.getCiudad(),
                dtoLugar.getImagen()
        );
    }
}