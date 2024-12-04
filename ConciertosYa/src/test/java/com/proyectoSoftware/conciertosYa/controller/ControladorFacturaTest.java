package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.*;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioFactura;
import com.proyectoSoftware.conciertosYa.service.ServicioMetodoPago;
import com.proyectoSoftware.conciertosYa.entity.MetodoPago; // Asegúrate de importar MetodoPago
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ControladorFacturaTest {

    private ServicioFactura servicioFactura;
    private ServicioMetodoPago servicioMetodoPago;
    private ServicioCliente servicioCliente;
    private ControladorFactura controladorFactura;

    @BeforeEach
    void setUp() {
        servicioFactura = Mockito.mock(ServicioFactura.class);
        servicioMetodoPago = Mockito.mock(ServicioMetodoPago.class);
        servicioCliente = Mockito.mock(ServicioCliente.class);
        controladorFactura = new ControladorFactura(servicioFactura, servicioMetodoPago, servicioCliente);
    }

    @Test
    void testCrearFactura() {
        DtoMetodoPago metodoPago = new DtoMetodoPago(1, MetodoPago.TipoMetodoPago.TARJETA_DE_CREDITO); // Cambié esto
        DtoCliente cliente = new DtoCliente("12345678", "Juan Pérez", "juan@example.com", "123456789", "Dirección de Juan", "01-01-1980");
        DtoFactura nuevaFactura = new DtoFactura(null, LocalDateTime.now(), 500.00, 1, "12345678", "<xml>Detalles</xml>");
        DtoFactura facturaCreada = new DtoFactura(1, LocalDateTime.now(), 500.00, 1, "12345678", "<xml>Detalles</xml>");

        when(servicioMetodoPago.getMetodoPago(1)).thenReturn(metodoPago);
        when(servicioCliente.getCliente("12345678")).thenReturn(cliente);
        when(servicioFactura.crearFactura(any(DtoFactura.class), eq(metodoPago), eq(cliente))).thenReturn(facturaCreada);

        ResponseEntity<DtoFactura> response = controladorFactura.crearFactura(nuevaFactura);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(facturaCreada, response.getBody());
        verify(servicioMetodoPago, times(1)).getMetodoPago(1);
        verify(servicioCliente, times(1)).getCliente("12345678");
        verify(servicioFactura, times(1)).crearFactura(any(DtoFactura.class), eq(metodoPago), eq(cliente));
    }

    @Test
    void testGetFactura() {
        int facturaId = 1;
        DtoFactura factura = new DtoFactura(facturaId, LocalDateTime.now(), 500.00, 1, "12345678", "<xml>Detalles</xml>");

        when(servicioFactura.getFactura(facturaId)).thenReturn(factura);

        ResponseEntity<DtoFactura> response = controladorFactura.getFactura(facturaId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(factura, response.getBody());
        verify(servicioFactura, times(1)).getFactura(facturaId);
    }

    @Test
    void testGetAllFacturas() {
        List<DtoFactura> facturas = Arrays.asList(
                new DtoFactura(1, LocalDateTime.now(), 500.00, 1, "12345678", "<xml>Detalles</xml>"),
                new DtoFactura(2, LocalDateTime.now().plusDays(1), 1000.00, 2, "87654321", "<xml>Más detalles</xml>")
        );

        when(servicioFactura.getAllFacturas()).thenReturn(facturas);

        ResponseEntity<List<DtoFactura>> response = controladorFactura.getAllFacturas();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(facturas, response.getBody());
        verify(servicioFactura, times(1)).getAllFacturas();
    }

    @Test
    void testUpdateFactura() {
        int facturaId = 1;
        DtoFactura facturaActualizada = new DtoFactura(facturaId, LocalDateTime.now(), 700.00, 1, "12345678", "<xml>Actualizado</xml>");

        when(servicioFactura.updateFactura(eq(facturaId), any(DtoFactura.class))).thenReturn(facturaActualizada);

        ResponseEntity<DtoFactura> response = controladorFactura.updateFactura(facturaId, facturaActualizada);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(facturaActualizada, response.getBody());
        verify(servicioFactura, times(1)).updateFactura(eq(facturaId), any(DtoFactura.class));
    }

    @Test
    void testDeleteFactura() {
        int facturaId = 1;

        doNothing().when(servicioFactura).deleteFactura(facturaId);

        ResponseEntity<Void> response = controladorFactura.deleteFactura(facturaId);

        assertEquals(204, response.getStatusCodeValue());
        verify(servicioFactura, times(1)).deleteFactura(facturaId);
    }
}
