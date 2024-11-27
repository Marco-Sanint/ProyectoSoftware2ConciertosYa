package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.entity.Carrito;

public class MapperCarrito {

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
        // Aquí deberías buscar el Cliente por su cédula y asignarlo
        // Por ejemplo:
        // carrito.setCliente(clienteRepository.findById(dtoCarrito.getCedulaCliente()).orElse(null));
        carrito.setFechaCreacion(dtoCarrito.getFechaCreacion());
        return carrito;
    }
}