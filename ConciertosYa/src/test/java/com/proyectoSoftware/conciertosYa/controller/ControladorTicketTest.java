package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoTicket;
import com.proyectoSoftware.conciertosYa.entity.Ticket;
import com.proyectoSoftware.conciertosYa.service.ServicioTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ControladorTicketTest {

    private ServicioTicket servicioTicket;
    private ControladorTicket controladorTicket;

    @BeforeEach
    void setUp() {
        // Mock del servicio
        servicioTicket = Mockito.mock(ServicioTicket.class);

        // Inicializar el controlador con el servicio mock
        controladorTicket = new ControladorTicket(servicioTicket);
    }

    @Test
    void testCreateTicket() {
        // Datos de prueba
        DtoTicket nuevoTicket = new DtoTicket(null, LocalDateTime.now(), 50.0, 1, "123456789");

        // Crear el objeto que será devuelto por el servicio
        DtoTicket ticketGuardado = new DtoTicket(1, LocalDateTime.now(), 50.0, 1, "123456789");

        // Configuración del mock
        when(servicioTicket.createTicket(any(DtoTicket.class))).thenReturn(ticketGuardado);

        // Llamada al controlador
        ResponseEntity<DtoTicket> response = controladorTicket.createTicket(nuevoTicket);

        // Verificaciones
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ticketGuardado, response.getBody());
        verify(servicioTicket, times(1)).createTicket(any(DtoTicket.class));
    }

    @Test
    void testGetTicketById() {
        Integer ticketId = 1;
        DtoTicket ticket = new DtoTicket(ticketId, LocalDateTime.now(), 50.0, 1, "123456789");

        when(servicioTicket.getTicket(ticketId)).thenReturn(ticket);

        ResponseEntity<DtoTicket> response = controladorTicket.getTicketById(ticketId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ticket, response.getBody());
        verify(servicioTicket, times(1)).getTicket(ticketId);
    }

    @Test
    void testGetAllTickets() {
        List<DtoTicket> tickets = Arrays.asList(
                new DtoTicket(1, LocalDateTime.now(), 50.0, 1, "123456789"),
                new DtoTicket(2, LocalDateTime.now(), 60.0, 2, "987654321")
        );

        when(servicioTicket.getAllTickets()).thenReturn(tickets);

        ResponseEntity<List<DtoTicket>> response = controladorTicket.getAllTickets();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tickets, response.getBody());
        verify(servicioTicket, times(1)).getAllTickets();
    }

    @Test
    void testUpdateTicket() {
        Integer ticketId = 1;
        DtoTicket ticketActualizado = new DtoTicket(ticketId, LocalDateTime.now(), 55.0, 1, "123456789");

        when(servicioTicket.updateTicket(eq(ticketId), any(DtoTicket.class))).thenReturn(ticketActualizado);

        ResponseEntity<DtoTicket> response = controladorTicket.updateTicket(ticketId, ticketActualizado);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ticketActualizado, response.getBody());
        verify(servicioTicket, times(1)).updateTicket(eq(ticketId), any(DtoTicket.class));
    }

    @Test
    void testDeleteTicket() {
        Integer ticketId = 1;

        doNothing().when(servicioTicket).deleteTicket(ticketId);

        ResponseEntity<String> response = controladorTicket.deleteTicket(ticketId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ticket eliminado", response.getBody());
        verify(servicioTicket, times(1)).deleteTicket(ticketId);
    }
}
