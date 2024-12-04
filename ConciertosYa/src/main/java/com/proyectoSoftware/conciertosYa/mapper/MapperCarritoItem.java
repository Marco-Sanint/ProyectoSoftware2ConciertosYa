package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
import com.proyectoSoftware.conciertosYa.entity.CarritoItem;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioCarrito;

public class MapperCarritoItem {

    private static ServicioCarrito servicioCarrito;
    private static ServicioAsiento servicioAsiento;

    public static DtoCarritoItem mapADtoCarritoItem(CarritoItem carritoItem) {
        return new DtoCarritoItem(
                carritoItem.getCarrito_item_id(),
                carritoItem.getCarrito().getCarrito_id(),
                carritoItem.getAsiento().getAsiento_id(),
                carritoItem.getCantidad()
        );
    }

    public static CarritoItem mapACarritoItem(DtoCarritoItem dtoCarritoItem) {
        CarritoItem carritoItem = new CarritoItem();
        carritoItem.setCarrito_item_id(dtoCarritoItem.getCarritoItemId());
        carritoItem.setCarrito(MapperCarrito.mapACarrito(servicioCarrito.getCarrito(dtoCarritoItem.getCarritoId())));
        carritoItem.setAsiento(MapperAsiento.mapAAsiento(servicioAsiento.getAsiento(dtoCarritoItem.getAsientoId())));
        carritoItem.setCantidad(dtoCarritoItem.getCantidad());
        return carritoItem;
    }
}