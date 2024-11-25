package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoArtista;
import com.proyectoSoftware.conciertosYa.entity.Artista;
import com.proyectoSoftware.conciertosYa.mapper.MapperArtista;
import com.proyectoSoftware.conciertosYa.repository.RepoArtista;
import com.proyectoSoftware.conciertosYa.service.ServicioArtista;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioArtista implements ServicioArtista {

    private final RepoArtista repoArtista;

    public ImplServicioArtista(RepoArtista repoArtista) {
        this.repoArtista = repoArtista;
    }

    @Override
    public DtoArtista crearArtista(DtoArtista dtoArtista) {
        Artista artista = MapperArtista.mapAArtista(dtoArtista); // Usar mapper para convertir DTO a entidad
        Artista artistaGuardado = repoArtista.save(artista); // Guardar en la base de datos
        return MapperArtista.mapADtoArtista(artistaGuardado); // Convertir entidad guardada a DTO
    }

    @Override
    public DtoArtista getArtista(Integer id) {
        Artista artista = repoArtista.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista no encontrado")); // Buscar entidad por ID
        return MapperArtista.mapADtoArtista(artista); // Convertir entidad encontrada a DTO
    }

    @Override
    public DtoArtista actualizarArtista(Integer id, DtoArtista dtoArtista) {
        Artista artista = repoArtista.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista no encontrado")); // Buscar entidad por ID

        // Actualizar campos
        artista.setNombre(dtoArtista.getNombre());
        artista.setGeneroMusical(dtoArtista.getGeneroMusical());
        artista.setRedesSociales(dtoArtista.getRedesSociales());

        Artista artistaActualizado = repoArtista.save(artista); // Guardar cambios
        return MapperArtista.mapADtoArtista(artistaActualizado); // Convertir entidad actualizada a DTO
    }

    @Override
    public void eliminarArtista(Integer id) {
        Artista artista = repoArtista.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista no encontrado")); // Buscar entidad por ID
        repoArtista.delete(artista); // Eliminar la entidad
    }

    @Override
    public List<DtoArtista> listarArtistas() {
        // Obtener todas las entidades y mapearlas a DTOs usando el mapper
        return repoArtista.findAll().stream()
                .map(MapperArtista::mapADtoArtista)
                .collect(Collectors.toList());
    }
}
