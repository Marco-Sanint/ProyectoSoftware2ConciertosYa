package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.entity.Carrito;

public class MapperCarrito {

    // Convertir entidad a DTO
    public static DtoCarrito mapADtoCarrito(Carrito carrito) {
        return new DtoCarrito(
                carrito.getId(),
                carrito.getCliente().getCedula(), // Usar cedula en lugar de clienteId
                carrito.getFechaCreacion()
        );
    }
    // Convertir DTO a entidad
    public static Carrito mapACarrito(DtoCarrito dtoCarrito, Cliente cliente) {
        return new Carrito(
                dtoCarrito.getId(),
                cliente, // Pasar directamente el cliente
                dtoCarrito.getFechaCreacion()
        );
    }

}
