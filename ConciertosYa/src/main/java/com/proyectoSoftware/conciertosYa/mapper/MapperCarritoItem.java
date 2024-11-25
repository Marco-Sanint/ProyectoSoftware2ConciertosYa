package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import com.proyectoSoftware.conciertosYa.entity.Carrito;
import com.proyectoSoftware.conciertosYa.entity.CarritoItem;

public class MapperCarritoItem {

    public static DtoCarritoItem mapADtoCarritoItem(CarritoItem carritoItem) {
        return new DtoCarritoItem(
                carritoItem.getId(),
                carritoItem.getCarrito().getId(),
                carritoItem.getAsiento().getAsiento_id(),
                carritoItem.getCantidad()
        );
    }

    public static CarritoItem mapACarritoItem(DtoCarritoItem dtoCarritoItem, Carrito carrito, Asiento asiento) {
        return new CarritoItem(
                dtoCarritoItem.getId(),
                carrito,
                asiento,
                dtoCarritoItem.getCantidad()
        );
    }
}
