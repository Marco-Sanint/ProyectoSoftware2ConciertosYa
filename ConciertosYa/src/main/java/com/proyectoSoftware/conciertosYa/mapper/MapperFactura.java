package com.proyectoSoftware.conciertosYa.mapper;

import com.proyectoSoftware.conciertosYa.dto.DtoFactura;
import com.proyectoSoftware.conciertosYa.entity.Factura;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioMetodoPago;
import com.proyectoSoftware.conciertosYa.service.ServicioPromocion;

public class MapperFactura {

    private static ServicioMetodoPago servicioMetodoPago00;
    private static ServicioCliente servicioCliente;

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
        factura.setMetodoPago(MapperMetodoPago.mapAMetodoPago(servicioMetodoPago00.getMetodoPago(dtoFactura.getMetodoPagoId())));
        factura.setCliente(MapperCliente.mapACliente(servicioCliente.getCliente(dtoFactura.getClienteCedula())));
        factura.setDetallesXml(dtoFactura.getDetallesXml());
        return factura;
    }
}