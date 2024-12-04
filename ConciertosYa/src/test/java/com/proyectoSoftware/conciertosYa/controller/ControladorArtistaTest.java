package com.proyectoSoftware.conciertosYa.controller;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;
import com.proyectoSoftware.conciertosYa.service.ServicioArtista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ControladorArtistaTest {

    @Mock
    private ServicioArtista servicioArtista;

    @InjectMocks
    private ControladorArtista controladorArtista;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearArtista() {
        // Arrange
        DtoArtista nuevoArtista = new DtoArtista(1, "Juanes", "Pop", "https://instagram.com/juanes");
        when(servicioArtista.crearArtista(nuevoArtista)).thenReturn(nuevoArtista);

        // Act
        ResponseEntity<DtoArtista> response = controladorArtista.crearArtista(nuevoArtista);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(nuevoArtista, response.getBody());
        verify(servicioArtista, times(1)).crearArtista(nuevoArtista);
    }

    @Test
    void testGetArtistaById() {
        // Arrange
        int artistaId = 1;
        DtoArtista artista = new DtoArtista(artistaId, "Shakira", "Pop", "https://twitter.com/shakira");
        when(servicioArtista.getArtista(artistaId)).thenReturn(artista);

        // Act
        ResponseEntity<DtoArtista> response = controladorArtista.getArtistaById(artistaId);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(artista, response.getBody());
        verify(servicioArtista, times(1)).getArtista(artistaId);
    }

    @Test
    void testActualizarArtista() {
        // Arrange
        int artistaId = 1;
        DtoArtista artistaActualizado = new DtoArtista(artistaId, "Maluma", "Reggaeton", "https://facebook.com/maluma");
        when(servicioArtista.updateArtista(artistaId, artistaActualizado)).thenReturn(artistaActualizado);

        // Act
        ResponseEntity<DtoArtista> response = controladorArtista.actualizarArtista(artistaId, artistaActualizado);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(artistaActualizado, response.getBody());
        verify(servicioArtista, times(1)).updateArtista(artistaId, artistaActualizado);
    }

    @Test
    void testEliminarArtista() {
        // Arrange
        int artistaId = 1;
        doNothing().when(servicioArtista).deleteArtista(artistaId);

        // Act
        ResponseEntity<Void> response = controladorArtista.eliminarArtista(artistaId);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(servicioArtista, times(1)).deleteArtista(artistaId);
    }

    @Test
    void testListarArtistas() {
        // Arrange
        List<DtoArtista> artistas = Arrays.asList(
                new DtoArtista(1, "Carlos Vives", "Vallenato", "https://instagram.com/carlosvives"),
                new DtoArtista(2, "Rihanna", "R&B", "https://twitter.com/rihanna")
        );
        when(servicioArtista.getAllArtistas()).thenReturn(artistas);

        // Act
        ResponseEntity<List<DtoArtista>> response = controladorArtista.listarArtistas();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(artistas, response.getBody());
        verify(servicioArtista, times(1)).getAllArtistas();
    }
}
