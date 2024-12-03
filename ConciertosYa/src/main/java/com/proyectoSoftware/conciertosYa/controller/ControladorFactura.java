package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.*;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioFactura;
import com.proyectoSoftware.conciertosYa.service.ServicioMetodoPago;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@AllArgsConstructor
public class ControladorFactura {

    private final ServicioFactura servicioFactura;
    private final ServicioMetodoPago servicioMetodoPago;
    private final ServicioCliente servicioCliente;

    @PostMapping
    public ResponseEntity<DtoFactura> crearFactura(@RequestBody DtoFactura dtoFactura) {
        DtoMetodoPago dtoMetodoPago = servicioMetodoPago.getMetodoPago(dtoFactura.getMetodoPagoId());
        DtoCliente dtoCliente = servicioCliente.getCliente(dtoFactura.getClienteCedula());

        DtoFactura facturaCreada = servicioFactura.crearFactura(dtoFactura, dtoMetodoPago, dtoCliente);
        return ResponseEntity.ok(facturaCreada);
    }

    @GetMapping("/{factura_id}")
    public ResponseEntity<DtoFactura> getFactura(@PathVariable Integer factura_id) {
        DtoFactura factura = servicioFactura.getFactura(factura_id);
        return ResponseEntity.ok(factura);
    }

    @GetMapping
    public ResponseEntity<List<DtoFactura>> getAllFacturas() {
        List<DtoFactura> facturas = servicioFactura.getAllFacturas();
        return ResponseEntity.ok(facturas);
    }

    @PutMapping("/{factura_id}")
    public ResponseEntity<DtoFactura> updateFactura(@PathVariable Integer factura_id, @RequestBody DtoFactura updateFactura) {
        DtoFactura facturaActualizada = servicioFactura.updateFactura(factura_id, updateFactura);
        return ResponseEntity.ok(facturaActualizada);
    }

    @DeleteMapping("/{factura_id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Integer factura_id) {
        servicioFactura.deleteFactura(factura_id);
        return ResponseEntity.noContent().build();
    }
}