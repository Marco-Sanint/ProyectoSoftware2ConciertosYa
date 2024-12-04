package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.*;
import com.proyectoSoftware.conciertosYa.service.ServicioDetalleFactura;
import com.proyectoSoftware.conciertosYa.service.ServicioPromocion;
import com.proyectoSoftware.conciertosYa.service.ServicioTicket;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/detalle-facturas")
public class ControladorDetalleFactura {

    private final ServicioDetalleFactura servicioDetalleFactura;
    private final ServicioPromocion servicioPromocion;
    private final ServicioTicket servicioTicket;

    @PostMapping
    public ResponseEntity<DtoDetalleFactura> createDetalleFactura(@RequestBody DtoDetalleFactura dtoDetalleFactura) {
        DtoPromocion dtoPromocion = servicioPromocion.getPromocion(dtoDetalleFactura.getPromocion());
        DtoTicket dtoTicket = servicioTicket.getTicket(dtoDetalleFactura.getTicketId());

        DtoDetalleFactura detalleFacturaCreado = servicioDetalleFactura.createDetalleFactura(dtoDetalleFactura, dtoPromocion, dtoTicket);
        return ResponseEntity.ok(detalleFacturaCreado);
    }

    @GetMapping("/{detalleFacturaId}")
    public ResponseEntity<DtoDetalleFactura> getDetalleFacturaById(@PathVariable("detalleFacturaId") Integer detalleFacturaId) {
        DtoDetalleFactura dtoDetalleFactura = servicioDetalleFactura.getDetalleFactura(detalleFacturaId);
        return ResponseEntity.ok(dtoDetalleFactura);
    }

    @GetMapping
    public ResponseEntity<List<DtoDetalleFactura>> getAllDetalleFacturas() {
        List<DtoDetalleFactura> detalleFacturas = servicioDetalleFactura.getAllDetalleFacturas();
        return ResponseEntity.ok(detalleFacturas);
    }

    @PutMapping("/{detalleFacturaId}")
    public ResponseEntity<DtoDetalleFactura> updateDetalleFactura(@PathVariable("detalleFacturaId") Integer detalleFacturaId,
                                                                  @RequestBody DtoDetalleFactura updateDetalleFactura) {
        DtoDetalleFactura dtoDetalleFactura = servicioDetalleFactura.updateDetalleFactura(detalleFacturaId, updateDetalleFactura);
        return ResponseEntity.ok(dtoDetalleFactura);
    }

    @DeleteMapping("/{detalleFacturaId}")
    public ResponseEntity<String> deleteDetalleFactura(@PathVariable("detalleFacturaId") Integer detalleFacturaId) {
        servicioDetalleFactura.deleteDetalleFactura(detalleFacturaId);
        return ResponseEntity.ok("DetalleFactura eliminado");
    }
}