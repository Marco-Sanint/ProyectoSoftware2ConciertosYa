package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class ControladorAsientoTest {

    @InjectMocks
    private ControladorAsiento controladorAsiento;

    @Mock
    private ServicioAsiento servicioAsiento;

    private DtoAsiento dtoAsiento;

    @BeforeEach
    void setUp() {
        dtoAsiento = new DtoAsiento(
                1,
                "A1",
                "1",
                50.0,
                Asiento.TipoAsiento.General,
                Asiento.EstadoAsiento.Disponible
        );
    }

    @Test
    void testCrearAsiento() {
        when(servicioAsiento.crearAsiento(any(DtoAsiento.class))).thenReturn(dtoAsiento);

        ResponseEntity<DtoAsiento> response = controladorAsiento.crearAsiento(dtoAsiento);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(dtoAsiento, response.getBody());

        verify(servicioAsiento, times(1)).crearAsiento(any(DtoAsiento.class));
    }

    @Test
    void testGetAsientoById() {
        when(servicioAsiento.getAsiento(1)).thenReturn(dtoAsiento);

        ResponseEntity<DtoAsiento> response = controladorAsiento.getAsientoById(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(dtoAsiento, response.getBody());

        verify(servicioAsiento, times(1)).getAsiento(1);
    }

    @Test
    void testGetAllAsientos() {
        List<DtoAsiento> asientos = new ArrayList<>();
        asientos.add(dtoAsiento);

        when(servicioAsiento.getAllAsiento()).thenReturn(asientos);

        ResponseEntity<List<DtoAsiento>> response = controladorAsiento.getAllAsientos();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(asientos, response.getBody());

        verify(servicioAsiento, times(1)).getAllAsiento();
    }

    @Test
    void testUpdateAsiento() {
        DtoAsiento updatedAsiento = new DtoAsiento(
                1,
                "B2",
                "2",
                75.0,
                Asiento.TipoAsiento.VIP,
                Asiento.EstadoAsiento.Reservado
        );

        when(servicioAsiento.updateAsiento(eq(1), any(DtoAsiento.class))).thenReturn(updatedAsiento);

        ResponseEntity<DtoAsiento> response = controladorAsiento.updateAsiento(1, updatedAsiento);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(updatedAsiento, response.getBody());

        verify(servicioAsiento, times(1)).updateAsiento(eq(1), any(DtoAsiento.class));
    }

    @Test
    void testDeleteAsiento() {
        doNothing().when(servicioAsiento).deleteAsiento(1);

        ResponseEntity<String> response = controladorAsiento.deleteAsiento(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Asiento eliminado", response.getBody());

        verify(servicioAsiento, times(1)).deleteAsiento(1);
    }
}
