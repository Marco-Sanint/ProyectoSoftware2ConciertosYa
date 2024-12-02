package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.dto.DtoFactura;
import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;

import java.util.List;

public interface ServicioFactura {
    DtoFactura crearFactura(DtoFactura dtoFactura, DtoMetodoPago dtoMetodoPago, DtoCliente dtoCliente);

    DtoFactura getFactura(Integer factura_id);

    List<DtoFactura> getAllFacturas();

    DtoFactura updateFactura(Integer factura_id, DtoFactura updateFactura);

    void deleteFactura(Integer factura_id);
}