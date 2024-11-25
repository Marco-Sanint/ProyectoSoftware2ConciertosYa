package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoFactura;
import com.proyectoSoftware.conciertosYa.entity.Cliente;
import com.proyectoSoftware.conciertosYa.entity.Factura;
import com.proyectoSoftware.conciertosYa.entity.MetodoPago;
import com.proyectoSoftware.conciertosYa.mapper.MapperFactura;
import com.proyectoSoftware.conciertosYa.repository.RepoCliente;
import com.proyectoSoftware.conciertosYa.repository.RepoFactura;
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

    public ImplServicioFactura(RepoFactura repoFactura, RepoCliente repoCliente, RepoMetodoPago repoMetodoPago) {
        this.repoFactura = repoFactura;
        this.repoCliente = repoCliente;
        this.repoMetodoPago = repoMetodoPago;
    }

    @Override
    public DtoFactura crearFactura(DtoFactura dtoFactura) {
        Cliente cliente = repoCliente.findById(dtoFactura.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        MetodoPago metodoPago = repoMetodoPago.findById(dtoFactura.getMetodoPagoId())
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

        Factura factura = MapperFactura.mapAFactura(dtoFactura, cliente, metodoPago);
        Factura facturaGuardada = repoFactura.save(factura);
        return MapperFactura.mapADtoFactura(facturaGuardada);
    }

    @Override
    public DtoFactura obtenerFactura(Integer id) {
        Factura factura = repoFactura.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        return MapperFactura.mapADtoFactura(factura);
    }

    @Override
    public DtoFactura actualizarFactura(Integer id, DtoFactura dtoFactura) {
        Factura factura = repoFactura.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        Cliente cliente = repoCliente.findById(dtoFactura.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        MetodoPago metodoPago = repoMetodoPago.findById(dtoFactura.getMetodoPagoId())
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

        factura.setFechaEmision(dtoFactura.getFechaEmision());
        factura.setTotal(dtoFactura.getTotal());
        factura.setCliente(cliente);
        factura.setMetodoPago(metodoPago);
        factura.setDetallesXml(dtoFactura.getDetallesXml());

        Factura facturaActualizada = repoFactura.save(factura);
        return MapperFactura.mapADtoFactura(facturaActualizada);
    }

    @Override
    public void eliminarFactura(Integer id) {
        Factura factura = repoFactura.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        repoFactura.delete(factura);
    }

    @Override
    public List<DtoFactura> listarFacturas() {
        return repoFactura.findAll().stream()
                .map(MapperFactura::mapADtoFactura)
                .collect(Collectors.toList());
    }
}
