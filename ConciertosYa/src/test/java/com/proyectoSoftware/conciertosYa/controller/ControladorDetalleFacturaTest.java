package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoDetalleFactura;
import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.entity.Promocion.TipoPromocion;
import com.proyectoSoftware.conciertosYa.service.ServicioDetalleFactura;
import com.proyectoSoftware.conciertosYa.service.ServicioPromocion;
import com.proyectoSoftware.conciertosYa.service.ServicioTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ControladorDetalleFacturaTest {

    private ServicioDetalleFactura servicioDetalleFactura;
    private ServicioPromocion servicioPromocion;
    private ServicioTicket servicioTicket;
    private ControladorDetalleFactura controladorDetalleFactura;

    @BeforeEach
    void setUp() {
        // Mock de los tres servicios requeridos por el controlador
        servicioDetalleFactura = Mockito.mock(ServicioDetalleFactura.class);
        servicioPromocion = Mockito.mock(ServicioPromocion.class);
        servicioTicket = Mockito.mock(ServicioTicket.class);

        // Inicializar el controlador con los tres servicios
        controladorDetalleFactura = new ControladorDetalleFactura(servicioDetalleFactura, servicioPromocion, servicioTicket);
    }

    @Test
    void testCreateDetalleFactura() {
        // Datos de prueba
        DtoDetalleFactura nuevoDetalleFactura = new DtoDetalleFactura(null, 2, 100.0, 0, 200.0, 1);

        // Crear objetos DtoPromocion y DtoTicket que serán devueltos por los servicios
        DtoPromocion dtoPromocion = new DtoPromocion(1, "Descuento Especial", "Código123", 10.0, LocalDate.now(), LocalDate.now().plusMonths(1), TipoPromocion.GENERAL);
        DtoTicket dtoTicket = new DtoTicket(1, LocalDateTime.now(), 150.0, 1, "Ticket Concierto");

        // Crear el objeto que será devuelto por el servicio
        DtoDetalleFactura detalleFacturaGuardado = new DtoDetalleFactura(1, 2, 100.0, 0, 200.0, 1);

        // Configuración del mock
        when(servicioPromocion.getPromocion(anyInt())).thenReturn(dtoPromocion);
        when(servicioTicket.getTicket(anyInt())).thenReturn(dtoTicket);
        when(servicioDetalleFactura.createDetalleFactura(any(DtoDetalleFactura.class), any(DtoPromocion.class), any(DtoTicket.class)))
                .thenReturn(detalleFacturaGuardado);

        // Llamada al controlador
        ResponseEntity<DtoDetalleFactura> response = controladorDetalleFactura.createDetalleFactura(nuevoDetalleFactura);

        // Verificaciones
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(detalleFacturaGuardado, response.getBody());
        verify(servicioDetalleFactura, times(1)).createDetalleFactura(any(DtoDetalleFactura.class), any(DtoPromocion.class), any(DtoTicket.class));
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
