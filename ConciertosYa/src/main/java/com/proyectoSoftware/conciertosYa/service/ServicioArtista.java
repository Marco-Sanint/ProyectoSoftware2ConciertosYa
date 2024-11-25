package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;

import java.util.List;

public interface ServicioArtista {
    DtoArtista crearArtista(DtoArtista dtoArtista); // Crear un artista
    DtoArtista getArtista(Integer id); // Obtener un artista por su ID
    DtoArtista actualizarArtista(Integer id, DtoArtista dtoArtista); // Actualizar un artista
    void eliminarArtista(Integer id); // Eliminar un artista por su ID
    List<DtoArtista> listarArtistas(); // Listar todos los artistas


}
