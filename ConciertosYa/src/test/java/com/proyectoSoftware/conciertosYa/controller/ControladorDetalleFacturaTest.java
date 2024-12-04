package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.service.ServicioDetalleFactura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ControladorDetalleFacturaTest {

    private ServicioDetalleFactura servicioDetalleFactura;
    private ControladorDetalleFactura controladorDetalleFactura;

    @BeforeEach
    void setUp() {
        servicioDetalleFactura = Mockito.mock(ServicioDetalleFactura.class);
        controladorDetalleFactura = new ControladorDetalleFactura(servicioDetalleFactura);
    }

    @Test
    void testCreateDetalleFactura() {
        DtoDetalleFactura nuevoDetalleFactura = new DtoDetalleFactura(null, 2, 100.0, 0, 200.0, 1);
        DtoDetalleFactura detalleFacturaGuardado = new DtoDetalleFactura(1, 2, 100.0, 0, 200.0, 1);

        when(servicioDetalleFactura.createDetalleFactura(any(DtoDetalleFactura.class))).thenReturn(detalleFacturaGuardado);

        ResponseEntity<DtoDetalleFactura> response = controladorDetalleFactura.createDetalleFactura(nuevoDetalleFactura);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(detalleFacturaGuardado, response.getBody());
        verify(servicioDetalleFactura, times(1)).createDetalleFactura(any(DtoDetalleFactura.class));
    }

    @Test
    void testGetDetalleFacturaById() {
        Integer detalleFacturaId = 1;
        DtoDetalleFactura detalleFactura = new DtoDetalleFactura(detalleFacturaId, 2, 100.0, 0, 200.0, 1);

        when(servicioDetalleFactura.getDetalleFactura(detalleFacturaId)).thenReturn(detalleFactura);

        ResponseEntity<DtoDetalleFactura> response = controladorDetalleFactura.getDetalleFacturaById(detalleFacturaId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(detalleFactura, response.getBody());
        verify(servicioDetalleFactura, times(1)).getDetalleFactura(detalleFacturaId);
    }

    @Test
    void testGetAllDetalleFacturas() {
        List<DtoDetalleFactura> detalleFacturas = Arrays.asList(
                new DtoDetalleFactura(1, 2, 100.0, 0, 200.0, 1),
                new DtoDetalleFactura(2, 3, 150.0, 1, 450.0, 2)
        );

        when(servicioDetalleFactura.getAllDetalleFacturas()).thenReturn(detalleFacturas);

        ResponseEntity<List<DtoDetalleFactura>> response = controladorDetalleFactura.getAllDetalleFacturas();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(detalleFacturas, response.getBody());
        verify(servicioDetalleFactura, times(1)).getAllDetalleFacturas();
    }

    @Test
    void testUpdateDetalleFactura() {
        Integer detalleFacturaId = 1;
        DtoDetalleFactura detalleFacturaActualizado = new DtoDetalleFactura(detalleFacturaId, 3, 120.0, 1, 360.0, 1);

        when(servicioDetalleFactura.updateDetalleFactura(eq(detalleFacturaId), any(DtoDetalleFactura.class))).thenReturn(detalleFacturaActualizado);

        ResponseEntity<DtoDetalleFactura> response = controladorDetalleFactura.updateDetalleFactura(detalleFacturaId, detalleFacturaActualizado);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(detalleFacturaActualizado, response.getBody());
        verify(servicioDetalleFactura, times(1)).updateDetalleFactura(eq(detalleFacturaId), any(DtoDetalleFactura.class));
    }

    @Test
    void testDeleteDetalleFactura() {
        Integer detalleFacturaId = 1;

        doNothing().when(servicioDetalleFactura).deleteDetalleFactura(detalleFacturaId);

        ResponseEntity<String> response = controladorDetalleFactura.deleteDetalleFactura(detalleFacturaId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("DetalleFactura eliminado", response.getBody());
        verify(servicioDetalleFactura, times(1)).deleteDetalleFactura(detalleFacturaId);
    }
}
