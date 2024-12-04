package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import com.proyectoSoftware.conciertosYa.dto.DtoCarrito;
import com.proyectoSoftware.conciertosYa.dto.DtoCarritoItem;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioCarrito;
import com.proyectoSoftware.conciertosYa.service.ServicioCarritoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ControladorCarritoItemTest {

    @InjectMocks
    private ControladorCarritoItem controladorCarritoItem;

    @Mock
    private ServicioCarritoItem servicioCarritoItem;

    @Mock
    private ServicioCarrito servicioCarrito;

    @Mock
    private ServicioAsiento servicioAsiento;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCarritoItem() {
        DtoCarritoItem dtoCarritoItem = new DtoCarritoItem(1, 1, 1, 2);
        DtoCarrito dtoCarrito = new DtoCarrito(1, "123456789", LocalDateTime.of(2024, 12, 1, 10, 0, 0));
        DtoAsiento dtoAsiento = new DtoAsiento(1, "A1", "Columna1", 50.0, Asiento.TipoAsiento.General, Asiento.EstadoAsiento.Disponible);
        DtoCarritoItem carritoItemCreado = new DtoCarritoItem(1, 1, 1, 2);

        when(servicioCarrito.getCarrito(1)).thenReturn(dtoCarrito);
        when(servicioAsiento.getAsiento(1)).thenReturn(dtoAsiento);
        when(servicioCarritoItem.createCarritoItem(any(), any(), any())).thenReturn(carritoItemCreado);

        ResponseEntity<DtoCarritoItem> response = controladorCarritoItem.createCarritoItem(dtoCarritoItem);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(carritoItemCreado, response.getBody());
        verify(servicioCarritoItem, times(1)).createCarritoItem(any(), any(), any());
    }


    @Test
    void testGetCarritoItemById() {
        DtoCarritoItem dtoCarritoItem = new DtoCarritoItem(1, 1, 1, 2);

        when(servicioCarritoItem.getCarritoItem(1)).thenReturn(dtoCarritoItem);

        ResponseEntity<DtoCarritoItem> response = controladorCarritoItem.getCarritoItemById(1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dtoCarritoItem, response.getBody());
        verify(servicioCarritoItem, times(1)).getCarritoItem(1);
    }

    @Test
    void testGetAllCarritoItems() {
        DtoCarritoItem item1 = new DtoCarritoItem(1, 1, 1, 2);
        DtoCarritoItem item2 = new DtoCarritoItem(2, 1, 2, 3);
        List<DtoCarritoItem> carritoItems = Arrays.asList(item1, item2);

        when(servicioCarritoItem.getAllCarritoItems()).thenReturn(carritoItems);

        ResponseEntity<List<DtoCarritoItem>> response = controladorCarritoItem.getAllCarritoItems();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(carritoItems, response.getBody());
        verify(servicioCarritoItem, times(1)).getAllCarritoItems();
    }

    @Test
    void testUpdateCarritoItem() {
        DtoCarritoItem dtoCarritoItem = new DtoCarritoItem(1, 1, 1, 2);

        when(servicioCarritoItem.updateCarritoItem(eq(1), any())).thenReturn(dtoCarritoItem);

        ResponseEntity<DtoCarritoItem> response = controladorCarritoItem.updateCarritoItem(1, dtoCarritoItem);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dtoCarritoItem, response.getBody());
        verify(servicioCarritoItem, times(1)).updateCarritoItem(eq(1), any());
    }

    @Test
    void testDeleteCarritoItem() {
        doNothing().when(servicioCarritoItem).deleteCarritoItem(1);

        ResponseEntity<String> response = controladorCarritoItem.deleteCarritoItem(1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("CarritoItem eliminado", response.getBody());
        verify(servicioCarritoItem, times(1)).deleteCarritoItem(1);
    }
}
