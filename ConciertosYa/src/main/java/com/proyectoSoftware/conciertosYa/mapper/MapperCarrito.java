package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.entity.Carrito;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;

public class MapperCarrito {

    private static ServicioCliente servicioCliente;

    public static DtoCarrito mapADtoCarrito(Carrito carrito) {
        return new DtoCarrito(
                carrito.getCarrito_id(),
                carrito.getCliente().getCedula(), // Asumiendo que Cliente tiene un método getCedula()
                carrito.getFechaCreacion()
        );
    }

    public static Carrito mapACarrito(DtoCarrito dtoCarrito) {
        Carrito carrito = new Carrito();
        carrito.setCarrito_id(dtoCarrito.getCarritoId());
        carrito.setCliente(MapperCliente.mapACliente(servicioCliente.getCliente(dtoCarrito.getCedulaCliente())));
        carrito.setFechaCreacion(dtoCarrito.getFechaCreacion());
        return carrito;
    }
}