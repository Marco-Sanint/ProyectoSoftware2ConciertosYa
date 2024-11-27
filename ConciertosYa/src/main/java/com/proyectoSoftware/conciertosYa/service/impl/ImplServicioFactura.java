package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoFactura;
import com.proyectoSoftware.conciertosYa.entity.Factura;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.entity.MetodoPago;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperFactura;
import com.proyectoSoftware.conciertosYa.repository.RepoFactura;
import com.proyectoSoftware.conciertosYa.repository.RepoCliente;
import com.proyectoSoftware.conciertosYa.repository.RepoMetodoPago;
import com.proyectoSoftware.conciertosYa.service.ServicioFactura;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioFactura implements ServicioFactura {

    private final RepoFactura repoFactura;
    private final RepoCliente repoCliente;
    private final RepoMetodoPago repoMetodoPago;

    @Override
    public DtoFactura crearFactura(DtoFactura dtoFactura) {
        MetodoPago metodoPago = repoMetodoPago.findById(dtoFactura.getMetodoPagoId())
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago no encontrado"));
        Cliente cliente = repoCliente.findById(dtoFactura.getClienteCedula())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        Factura factura = MapperFactura.mapAFactura(dtoFactura);
        factura.setMetodoPago(metodoPago);
        factura.setCliente(cliente);
        return MapperFactura.mapADtoFactura(repoFactura.save(factura));
    }

    @Override
    public DtoFactura getFactura(Integer factura_id) {
        Factura factura = repoFactura.findById(factura_id)
                .orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada"));
        return MapperFactura.mapADtoFactura(factura);
    }

    @Override
    public List<DtoFactura> getAllFacturas() {
        return repoFactura.findAll().stream()
                .map(MapperFactura::mapADtoFactura)
                .collect(Collectors.toList());
    }

    @Override
    public DtoFactura updateFactura(Integer factura_id, DtoFactura updateFactura) {
        Factura factura = repoFactura.findById(factura_id)
                .orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada"));

        factura.setFechaEmision(updateFactura.getFechaEmision());
        factura.setTotal(updateFactura.getTotal());
        factura.setDetallesXml(updateFactura.getDetallesXml());
        return MapperFactura.mapADtoFactura(repoFactura.save(factura));
    }

    @Override
    public void deleteFactura(Integer factura_id) {
        if (!repoFactura.existsById(factura_id)) {
            throw new ResourceNotFoundException("Factura no encontrada");
        }
        repoFactura.deleteById(factura_id);
    }
}