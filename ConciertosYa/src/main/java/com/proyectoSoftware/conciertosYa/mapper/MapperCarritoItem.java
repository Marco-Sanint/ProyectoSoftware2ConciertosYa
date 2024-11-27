package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
import com.proyectoSoftware.conciertosYa.entity.CarritoItem;

public class MapperCarritoItem {

    public static DtoCarritoItem mapADtoCarritoItem(CarritoItem carritoItem) {
        return new DtoCarritoItem(
                carritoItem.getCarrito_item_id(),
                carritoItem.getCarrito().getCarrito_id(), // Asumiendo que Carrito tiene un método getCarrito_id()
                carritoItem.getAsiento().getAsiento_id(), // Asumiendo que Asiento tiene un método getAsiento_id()
                carritoItem.getCantidad()
        );
    }

    public static CarritoItem mapACarritoItem(DtoCarritoItem dtoCarritoItem) {
        CarritoItem carritoItem = new CarritoItem();
        carritoItem.setCarrito_item_id(dtoCarritoItem.getCarritoItemId());
        // Aquí deberías buscar el Carrito y Asiento por sus IDs y asignarlos
        // Por ejemplo:
        // carritoItem.setCarrito(carritoRepository.findById(dtoCarritoItem.getCarritoId()).orElse(null));
        // carritoItem.setAsiento(asientoRepository.findById(dtoCarritoItem.getAsientoId()).orElse(null));
        carritoItem.setCantidad(dtoCarritoItem.getCantidad());
        return carritoItem;
    }
}