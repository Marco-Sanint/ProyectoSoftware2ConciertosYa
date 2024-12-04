package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.entity.Promocion;
import com.proyectoSoftware.conciertosYa.service.ServicioPromocion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ControladorPromocionTest {

    private ServicioPromocion servicioPromocion;
    private ControladorPromocion controladorPromocion;

    @BeforeEach
    void setUp() {
        // Mock del servicio
        servicioPromocion = Mockito.mock(ServicioPromocion.class);

        // Inicializar el controlador con el servicio mock
        controladorPromocion = new ControladorPromocion(servicioPromocion);
    }

    @Test
    void testCrearPromocion() {
        // Datos de prueba
        DtoPromocion nuevaPromocion = new DtoPromocion(null, "Promoción A", "Descuento para todos", 20.5, LocalDate.now(), LocalDate.now().plusDays(10), Promocion.TipoPromocion.GENERAL);

        // Crear el objeto que será devuelto por el servicio
        DtoPromocion promocionCreada = new DtoPromocion(1, "Promoción A", "Descuento para todos", 20.5, LocalDate.now(), LocalDate.now().plusDays(10), Promocion.TipoPromocion.GENERAL);

        // Configuración del mock
        when(servicioPromocion.crearPromocion(any(DtoPromocion.class))).thenReturn(promocionCreada);

        // Llamada al controlador
        ResponseEntity<DtoPromocion> response = controladorPromocion.crearPromocion(nuevaPromocion);

        // Verificaciones
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(promocionCreada, response.getBody());
        verify(servicioPromocion, times(1)).crearPromocion(any(DtoPromocion.class));
    }

    @Test
    void testGetPromocionById() {
        Integer promocionId = 1;
        DtoPromocion promocion = new DtoPromocion(promocionId, "Promoción A", "Descuento para todos", 20.5, LocalDate.now(), LocalDate.now().plusDays(10), Promocion.TipoPromocion.GENERAL);

        when(servicioPromocion.getPromocion(promocionId)).thenReturn(promocion);

        ResponseEntity<DtoPromocion> response = controladorPromocion.getPromocionById(promocionId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(promocion, response.getBody());
        verify(servicioPromocion, times(1)).getPromocion(promocionId);
    }

    @Test
    void testGetAllPromociones() {
        List<DtoPromocion> promociones = Arrays.asList(
                new DtoPromocion(1, "Promoción A", "Descuento para todos", 20.5, LocalDate.now(), LocalDate.now().plusDays(10), Promocion.TipoPromocion.GENERAL),
                new DtoPromocion(2, "Promoción B", "Descuento VIP", 30.0, LocalDate.now(), LocalDate.now().plusDays(15), Promocion.TipoPromocion.VIP)
        );

        when(servicioPromocion.getAllPromociones()).thenReturn(promociones);

        ResponseEntity<List<DtoPromocion>> response = controladorPromocion.getAllPromociones();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(promociones, response.getBody());
        verify(servicioPromocion, times(1)).getAllPromociones();
    }

    @Test
    void testUpdatePromocion() {
        Integer promocionId = 1;
        DtoPromocion promocionActualizada = new DtoPromocion(promocionId, "Promoción A", "Descuento actualizado", 25.0, LocalDate.now(), LocalDate.now().plusDays(12), Promocion.TipoPromocion.GENERAL);

        when(servicioPromocion.updatePromocion(eq(promocionId), any(DtoPromocion.class))).thenReturn(promocionActualizada);

        ResponseEntity<DtoPromocion> response = controladorPromocion.updatePromocion(promocionId, promocionActualizada);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(promocionActualizada, response.getBody());
        verify(servicioPromocion, times(1)).updatePromocion(eq(promocionId), any(DtoPromocion.class));
    }

    @Test
    void testDeletePromocion() {
        Integer promocionId = 1;

        doNothing().when(servicioPromocion).deletePromocion(promocionId);

        ResponseEntity<String> response = controladorPromocion.deletePromocion(promocionId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Promocion eliminada", response.getBody());
        verify(servicioPromocion, times(1)).deletePromocion(promocionId);
    }
}
