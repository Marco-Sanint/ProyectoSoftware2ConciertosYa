package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.dto.DtoCliente;
import com.proyectoSoftware.conciertosYa.service.ServicioCarrito;
import com.proyectoSoftware.conciertosYa.service.ServicioCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class ControladorCarritoTest {

    @InjectMocks
    private ControladorCarrito controladorCarrito;

    @Mock
    private ServicioCarrito servicioCarrito;

    @Mock
    private ServicioCliente servicioCliente;

    private DtoCarrito dtoCarrito;
    private DtoCliente dtoCliente;

    @BeforeEach
    void setUp() {
        dtoCliente = new DtoCliente("123456789", "Juan", "Perez", "correo@ejemplo.com", "direccion", "telefono");
        dtoCarrito = new DtoCarrito(1, "123456789", LocalDateTime.now());
    }

    @Test
    void testCrearCarrito() {
        when(servicioCliente.getCliente(dtoCarrito.getCedulaCliente())).thenReturn(dtoCliente);
        when(servicioCarrito.createCarrito(any(DtoCarrito.class), any(DtoCliente.class))).thenReturn(dtoCarrito);

        ResponseEntity<DtoCarrito> response = controladorCarrito.crearCarrito(dtoCarrito);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dtoCarrito, response.getBody());

        verify(servicioCliente, times(1)).getCliente(dtoCarrito.getCedulaCliente());
        verify(servicioCarrito, times(1)).createCarrito(any(DtoCarrito.class), any(DtoCliente.class));
    }

    @Test
    void testGetCarrito() {
        when(servicioCarrito.getCarrito(1)).thenReturn(dtoCarrito);

        ResponseEntity<DtoCarrito> response = controladorCarrito.getCarrito(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dtoCarrito, response.getBody());

        verify(servicioCarrito, times(1)).getCarrito(1);
    }

    @Test
    void testGetAllCarritos() {
        List<DtoCarrito> carritos = new ArrayList<>();
        carritos.add(dtoCarrito);

        when(servicioCarrito.getAllCarritos()).thenReturn(carritos);

        ResponseEntity<List<DtoCarrito>> response = controladorCarrito.getAllCarritos();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(carritos, response.getBody());

        verify(servicioCarrito, times(1)).getAllCarritos();
    }

    @Test
    void testUpdateCarrito() {
        DtoCarrito updatedCarrito = new DtoCarrito(1, "987654321", LocalDateTime.now());

        when(servicioCarrito.updateCarrito(eq(1), any(DtoCarrito.class))).thenReturn(updatedCarrito);

        ResponseEntity<DtoCarrito> response = controladorCarrito.updateCarrito(1, updatedCarrito);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(updatedCarrito, response.getBody());

        verify(servicioCarrito, times(1)).updateCarrito(eq(1), any(DtoCarrito.class));
    }

    @Test
    void testDeleteCarrito() {
        doNothing().when(servicioCarrito).deleteCarrito(1);

        ResponseEntity<Void> response = controladorCarrito.deleteCarrito(1);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());

        verify(servicioCarrito, times(1)).deleteCarrito(1);
    }
}
