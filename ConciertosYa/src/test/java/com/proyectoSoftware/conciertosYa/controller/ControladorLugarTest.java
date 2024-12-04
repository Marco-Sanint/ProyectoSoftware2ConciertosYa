package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ControladorLugarTest {

    private ServicioLugar servicioLugar;
    private ControladorLugar controladorLugar;

    @BeforeEach
    void setUp() {
        // Simula el servicio con Mockito
        servicioLugar = Mockito.mock(ServicioLugar.class);
        controladorLugar = new ControladorLugar(servicioLugar);
    }

    @Test
    void testCrearLugar() {
        // Datos de prueba
        DtoLugar nuevoLugar = new DtoLugar(0, "Auditorio Nacional", "Av. Reforma 50", 10000, "Ciudad de México", "imagen1.jpg");
        DtoLugar lugarCreado = new DtoLugar(1, "Auditorio Nacional", "Av. Reforma 50", 10000, "Ciudad de México", "imagen1.jpg");

        // Configuración del mock
        when(servicioLugar.crearLugar(any(DtoLugar.class))).thenReturn(lugarCreado);

        // Llamada al controlador
        ResponseEntity<DtoLugar> response = controladorLugar.crearLugar(nuevoLugar);

        // Verificaciones
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(lugarCreado, response.getBody());
        verify(servicioLugar, times(1)).crearLugar(any(DtoLugar.class));
    }

    @Test
    void testGetLugar() {
        // Datos de prueba
        int lugarId = 1;
        DtoLugar lugar = new DtoLugar(lugarId, "Teatro de la Ciudad", "Calle Donceles 36", 500, "Ciudad de México", "imagen2.jpg");

        // Configuración del mock
        when(servicioLugar.getLugar(lugarId)).thenReturn(lugar);

        // Llamada al controlador
        ResponseEntity<DtoLugar> response = controladorLugar.getLugar(lugarId);

        // Verificaciones
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(lugar, response.getBody());
        verify(servicioLugar, times(1)).getLugar(lugarId);
    }

    @Test
    void testGetAllLugares() {
        // Datos de prueba
        List<DtoLugar> lugares = Arrays.asList(
                new DtoLugar(1, "Palacio de Bellas Artes", "Av. Juárez S/N", 3000, "Ciudad de México", "imagen3.jpg"),
                new DtoLugar(2, "Estadio Azteca", "Calzada de Tlalpan 3465", 87000, "Ciudad de México", "imagen4.jpg")
        );

        // Configuración del mock
        when(servicioLugar.getAllLugares()).thenReturn(lugares);

        // Llamada al controlador
        ResponseEntity<List<DtoLugar>> response = controladorLugar.getAllLugares();

        // Verificaciones
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(lugares, response.getBody());
        verify(servicioLugar, times(1)).getAllLugares();
    }

    @Test
    void testUpdateLugar() {
        // Datos de prueba
        int lugarId = 1;
        DtoLugar lugarActualizado = new DtoLugar(lugarId, "Foro Sol", "Viaducto Río de la Piedad", 65000, "Ciudad de México", "imagen5.jpg");

        // Configuración del mock
        when(servicioLugar.updateLugar(eq(lugarId), any(DtoLugar.class))).thenReturn(lugarActualizado);

        // Llamada al controlador
        ResponseEntity<DtoLugar> response = controladorLugar.updateLugar(lugarId, lugarActualizado);

        // Verificaciones
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(lugarActualizado, response.getBody());
        verify(servicioLugar, times(1)).updateLugar(eq(lugarId), any(DtoLugar.class));
    }

    @Test
    void testDeleteLugar() {
        // Datos de prueba
        int lugarId = 1;

        // Configuración del mock
        doNothing().when(servicioLugar).deleteLugar(lugarId);

        // Llamada al controlador
        ResponseEntity<Void> response = controladorLugar.deleteLugar(lugarId);

        // Verificaciones
        assertEquals(204, response.getStatusCodeValue());
        verify(servicioLugar, times(1)).deleteLugar(lugarId);
    }
}
