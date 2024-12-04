package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoArtistaEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioArtistaEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioArtista;
import com.proyectoSoftware.conciertosYa.service.ServicioEvento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ControladorArtistaEventoTest {

    @InjectMocks
    private ControladorArtistaEvento controladorArtistaEvento;

    @Mock
    private ServicioArtistaEvento servicioArtistaEvento;

    @Mock
    private ServicioArtista servicioArtista;

    @Mock
    private ServicioEvento servicioEvento;

    private DtoArtistaEvento dtoArtistaEvento;

    @BeforeEach
    void setUp() {
        dtoArtistaEvento = new DtoArtistaEvento(1, 2, 3); // Creación de un DTO para el test
    }

    @Test
    void testCreateArtistaEvento() {
        // Datos de prueba para el servicio mockeado
        DtoArtistaEvento dtoArtistaEventoCreado = new DtoArtistaEvento(1, 2, 3);

        // Configuración de los mocks
        when(servicioArtistaEvento.createArtistaEvento(any(DtoArtistaEvento.class), any(), any()))
                .thenReturn(dtoArtistaEventoCreado);
        when(servicioArtista.getArtista(anyInt())).thenReturn(null); // Simula el servicio de artista
        when(servicioEvento.getEvento(anyInt())).thenReturn(null); // Simula el servicio de evento

        // Llamada al controlador
        ResponseEntity<DtoArtistaEvento> response = controladorArtistaEvento.createArtistaEvento(dtoArtistaEvento);

        // Verificación de la respuesta
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dtoArtistaEventoCreado, response.getBody());

        // Verificar que el servicio fue llamado una vez
        verify(servicioArtistaEvento, times(1)).createArtistaEvento(any(DtoArtistaEvento.class), any(), any());
    }

    @Test
    void testGetArtistaEventoById() {
        // Datos de prueba para el servicio mockeado
        DtoArtistaEvento dtoArtistaEventoCreado = new DtoArtistaEvento(1, 2, 3);

        // Configuración del mock
        when(servicioArtistaEvento.getArtistaEvento(1)).thenReturn(dtoArtistaEventoCreado);

        // Llamada al controlador
        ResponseEntity<DtoArtistaEvento> response = controladorArtistaEvento.getArtistaEventoById(1);

        // Verificación de la respuesta
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dtoArtistaEventoCreado, response.getBody());

        // Verificar que el servicio fue llamado una vez
        verify(servicioArtistaEvento, times(1)).getArtistaEvento(1);
    }
}
