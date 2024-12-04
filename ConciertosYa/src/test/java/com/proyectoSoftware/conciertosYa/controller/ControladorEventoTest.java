package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoEvento;
import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.entity.Evento.EstadoEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioEvento;
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ControladorEventoTest {

    private ServicioEvento servicioEvento;
    private ServicioLugar servicioLugar;
    private ControladorEvento controladorEvento;

    @BeforeEach
    void setUp() {
        servicioEvento = Mockito.mock(ServicioEvento.class);
        servicioLugar = Mockito.mock(ServicioLugar.class);
        controladorEvento = new ControladorEvento(servicioEvento, servicioLugar);
    }

    @Test
    void testCrearEvento() {
        // Constructor corregido para DtoLugar
        DtoLugar lugar = new DtoLugar(1, "Teatro Nacional", "Calle 123", 1000, "Ciudad XYZ", "País ABC");
        DtoEvento nuevoEvento = new DtoEvento(0, "Concierto de Rock", LocalDate.now(), LocalTime.of(20, 0),
                "Concierto increíble", "Rock", EstadoEvento.PROGRAMADO, "imagen.jpg", 1);
        DtoEvento eventoCreado = new DtoEvento(1, "Concierto de Rock", LocalDate.now(), LocalTime.of(20, 0),
                "Concierto increíble", "Rock", EstadoEvento.PROGRAMADO, "imagen.jpg", 1);

        when(servicioLugar.getLugar(1)).thenReturn(lugar);
        when(servicioEvento.crearEvento(any(DtoEvento.class), eq(lugar))).thenReturn(eventoCreado);

        ResponseEntity<DtoEvento> response = controladorEvento.crearEvento(nuevoEvento);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(eventoCreado, response.getBody());
        verify(servicioLugar, times(1)).getLugar(1);
        verify(servicioEvento, times(1)).crearEvento(any(DtoEvento.class), eq(lugar));
    }

    @Test
    void testGetEvento() {
        int eventoId = 1;
        DtoEvento evento = new DtoEvento(eventoId, "Concierto de Rock", LocalDate.now(), LocalTime.of(20, 0),
                "Concierto increíble", "Rock", EstadoEvento.PROGRAMADO, "imagen.jpg", 1);

        when(servicioEvento.getEvento(eventoId)).thenReturn(evento);

        ResponseEntity<DtoEvento> response = controladorEvento.getEvento(eventoId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(evento, response.getBody());
        verify(servicioEvento, times(1)).getEvento(eventoId);
    }

    @Test
    void testGetAllEventos() {
        List<DtoEvento> eventos = Arrays.asList(
                new DtoEvento(1, "Concierto de Rock", LocalDate.now(), LocalTime.of(20, 0), "Concierto increíble",
                        "Rock", EstadoEvento.PROGRAMADO, "imagen.jpg", 1),
                new DtoEvento(2, "Concierto de Jazz", LocalDate.now().plusDays(1), LocalTime.of(21, 0), "Música en vivo",
                        "Jazz", EstadoEvento.PROGRAMADO, "imagen2.jpg", 2)
        );

        when(servicioEvento.getAllEventos()).thenReturn(eventos);

        ResponseEntity<List<DtoEvento>> response = controladorEvento.getAllEventos();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(eventos, response.getBody());
        verify(servicioEvento, times(1)).getAllEventos();
    }

    @Test
    void testUpdateEvento() {
        int eventoId = 1;
        DtoEvento eventoActualizado = new DtoEvento(eventoId, "Concierto de Rock Editado", LocalDate.now(),
                LocalTime.of(21, 0), "Descripción actualizada", "Rock", EstadoEvento.PROGRAMADO, "imagen_updated.jpg", 1);

        when(servicioEvento.updateEvento(eq(eventoId), any(DtoEvento.class))).thenReturn(eventoActualizado);

        ResponseEntity<DtoEvento> response = controladorEvento.updateEvento(eventoId, eventoActualizado);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(eventoActualizado, response.getBody());
        verify(servicioEvento, times(1)).updateEvento(eq(eventoId), any(DtoEvento.class));
    }

    @Test
    void testDeleteEvento() {
        int eventoId = 1;

        doNothing().when(servicioEvento).deleteEvento(eventoId);

        ResponseEntity<Void> response = controladorEvento.deleteEvento(eventoId);

        assertEquals(204, response.getStatusCodeValue());
        verify(servicioEvento, times(1)).deleteEvento(eventoId);
    }
}
