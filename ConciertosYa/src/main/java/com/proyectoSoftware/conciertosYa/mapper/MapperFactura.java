package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoFactura;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.entity.Factura;
import com.proyectoSoftware.conciertosYa.entity.MetodoPago;

public class MapperFactura {

    public static DtoFactura mapADtoFactura(Factura factura) {
        return new DtoFactura(
                factura.getId(),
                factura.getFechaEmision(),
                factura.getTotal(),
                factura.getMetodoPago() != null ? factura.getMetodoPago().getId() : null,
                factura.getCliente() != null ? factura.getCliente().getId() : null,
                factura.getDetallesXml()
        );
    }

    public static Factura mapAFactura(DtoFactura dtoFactura, Cliente cliente, MetodoPago metodoPago) {
        return new Factura(
                dtoFactura.getId(),
                dtoFactura.getFechaEmision(),
                dtoFactura.getTotal(),
                metodoPago,
                cliente,
                dtoFactura.getDetallesXml()
        );
    }
}
