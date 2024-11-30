package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoFactura;
import com.proyectoSoftware.conciertosYa.entity.Factura;

public class MapperFactura {

    public static DtoFactura mapADtoFactura(Factura factura) {
        return new DtoFactura(
                factura.getFactura_id(),
                factura.getFechaEmision(),
                factura.getTotal(),
                factura.getMetodoPago() != null ? factura.getMetodoPago().getMetodo_pago_id() : null,
                factura.getCliente() != null ? factura.getCliente().getCedula() : null,
                factura.getDetallesXml()
        );
    }

    public static Factura mapAFactura(DtoFactura dtoFactura) {
        Factura factura = new Factura();
        factura.setFactura_id(dtoFactura.getFactura_id());
        factura.setFechaEmision(dtoFactura.getFechaEmision());
        factura.setTotal(dtoFactura.getTotal());
        factura.setDetallesXml(dtoFactura.getDetallesXml());
        return factura;
    }
}