package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoMetodoPago;
import com.proyectoSoftware.conciertosYa.entity.MetodoPago;
import com.proyectoSoftware.conciertosYa.service.ServicioMetodoPago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ControladorMetodoPagoTest {

    private ServicioMetodoPago servicioMetodoPago;
    private ControladorMetodoPago controladorMetodoPago;

    @BeforeEach
    void setUp() {
        // Mock del servicio
        servicioMetodoPago = Mockito.mock(ServicioMetodoPago.class);

        // Inicializar el controlador con el servicio mock
        controladorMetodoPago = new ControladorMetodoPago(servicioMetodoPago);
    }

    @Test
    void testCrearMetodoPago() {
        // Datos de prueba
        DtoMetodoPago nuevoMetodoPago = new DtoMetodoPago(null, MetodoPago.TipoMetodoPago.TARJETA_DE_CREDITO);

        // Crear el objeto que será devuelto por el servicio
        DtoMetodoPago metodoPagoCreado = new DtoMetodoPago(1, MetodoPago.TipoMetodoPago.TARJETA_DE_CREDITO);

        // Configuración del mock
        when(servicioMetodoPago.crearMetodoPago(any(DtoMetodoPago.class))).thenReturn(metodoPagoCreado);

        // Llamada al controlador
        ResponseEntity<DtoMetodoPago> response = controladorMetodoPago.crearMetodoPago(nuevoMetodoPago);

        // Verificaciones
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(metodoPagoCreado, response.getBody());
        verify(servicioMetodoPago, times(1)).crearMetodoPago(any(DtoMetodoPago.class));
    }

    @Test
    void testGetMetodoPago() {
        Integer metodoPagoId = 1;
        DtoMetodoPago metodoPago = new DtoMetodoPago(metodoPagoId, MetodoPago.TipoMetodoPago.TARJETA_DE_CREDITO);

        when(servicioMetodoPago.getMetodoPago(metodoPagoId)).thenReturn(metodoPago);

        ResponseEntity<DtoMetodoPago> response = controladorMetodoPago.getMetodoPago(metodoPagoId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(metodoPago, response.getBody());
        verify(servicioMetodoPago, times(1)).getMetodoPago(metodoPagoId);
    }

    @Test
    void testGetAllMetodosPago() {
        List<DtoMetodoPago> metodosPago = Arrays.asList(
                new DtoMetodoPago(1, MetodoPago.TipoMetodoPago.EFECTIVO),
                new DtoMetodoPago(2, MetodoPago.TipoMetodoPago.TARJETA_DE_CREDITO)
        );

        when(servicioMetodoPago.getAllMetodosPago()).thenReturn(metodosPago);

        ResponseEntity<List<DtoMetodoPago>> response = controladorMetodoPago.getAllMetodosPago();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(metodosPago, response.getBody());
        verify(servicioMetodoPago, times(1)).getAllMetodosPago();
    }

    @Test
    void testUpdateMetodoPago() {
        Integer metodoPagoId = 1;
        DtoMetodoPago metodoPagoActualizado = new DtoMetodoPago(metodoPagoId, MetodoPago.TipoMetodoPago.EFECTIVO_Y_TARJETA_DE_CREDITO);

        when(servicioMetodoPago.updateMetodoPago(eq(metodoPagoId), any(DtoMetodoPago.class))).thenReturn(metodoPagoActualizado);

        ResponseEntity<DtoMetodoPago> response = controladorMetodoPago.updateMetodoPago(metodoPagoId, metodoPagoActualizado);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(metodoPagoActualizado, response.getBody());
        verify(servicioMetodoPago, times(1)).updateMetodoPago(eq(metodoPagoId), any(DtoMetodoPago.class));
    }

    @Test
    void testDeleteMetodoPago() {
        Integer metodoPagoId = 1;

        doNothing().when(servicioMetodoPago).deleteMetodoPago(metodoPagoId);

        ResponseEntity<Void> response = controladorMetodoPago.deleteMetodoPago(metodoPagoId);

        assertEquals(204, response.getStatusCodeValue());
        verify(servicioMetodoPago, times(1)).deleteMetodoPago(metodoPagoId);
    }
}
