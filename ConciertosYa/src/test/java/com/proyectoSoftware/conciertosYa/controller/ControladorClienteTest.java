package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ControladorClienteTest {

    private ServicioCliente servicioCliente;
    private ControladorCliente controladorCliente;

    @BeforeEach
    void setUp() {
        servicioCliente = Mockito.mock(ServicioCliente.class);
        controladorCliente = new ControladorCliente(servicioCliente);
    }

    @Test
    void testCreateCliente() {
        DtoCliente nuevoCliente = new DtoCliente("123456789", "Juan Perez", "555123456", "juan@example.com", "Calle 123", "password123");
        DtoCliente clienteGuardado = new DtoCliente("123456789", "Juan Perez", "555123456", "juan@example.com", "Calle 123", "password123");

        when(servicioCliente.createCliente(any(DtoCliente.class))).thenReturn(clienteGuardado);

        ResponseEntity<DtoCliente> response = controladorCliente.createCliente(nuevoCliente);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(clienteGuardado, response.getBody());
        verify(servicioCliente, times(1)).createCliente(any(DtoCliente.class));
    }

    @Test
    void testGetClienteById() {
        String cedula = "123456789";
        DtoCliente cliente = new DtoCliente(cedula, "Juan Perez", "555123456", "juan@example.com", "Calle 123", "password123");

        when(servicioCliente.getCliente(cedula)).thenReturn(cliente);

        ResponseEntity<DtoCliente> response = controladorCliente.getClienteById(cedula);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(cliente, response.getBody());
        verify(servicioCliente, times(1)).getCliente(cedula);
    }

    @Test
    void testGetAllClientes() {
        List<DtoCliente> clientes = Arrays.asList(
                new DtoCliente("123456789", "Juan Perez", "555123456", "juan@example.com", "Calle 123", "password123"),
                new DtoCliente("987654321", "Maria Lopez", "555654321", "maria@example.com", "Avenida 456", "password321")
        );

        when(servicioCliente.getAllClientes()).thenReturn(clientes);

        ResponseEntity<List<DtoCliente>> response = controladorCliente.getAllClientes();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clientes, response.getBody());
        verify(servicioCliente, times(1)).getAllClientes();
    }

    @Test
    void testUpdateCliente() {
        String cedula = "123456789";
        DtoCliente clienteActualizado = new DtoCliente(cedula, "Juan Perez Updated", "555123456", "juan_updated@example.com", "Calle 123 Updated", "password123");

        when(servicioCliente.updateCliente(eq(cedula), any(DtoCliente.class))).thenReturn(clienteActualizado);

        ResponseEntity<DtoCliente> response = controladorCliente.updateCliente(cedula, clienteActualizado);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clienteActualizado, response.getBody());
        verify(servicioCliente, times(1)).updateCliente(eq(cedula), any(DtoCliente.class));
    }

    @Test
    void testDeleteCliente() {
        String cedula = "123456789";

        doNothing().when(servicioCliente).deleteCliente(cedula);

        ResponseEntity<String> response = controladorCliente.deleteCliente(cedula);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Cliente eliminado", response.getBody());
        verify(servicioCliente, times(1)).deleteCliente(cedula);
    }
}
