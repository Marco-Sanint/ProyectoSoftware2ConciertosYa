package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.entity.Promocion;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperPromocion;
import com.proyectoSoftware.conciertosYa.repository.RepoPromocion;
import com.proyectoSoftware.conciertosYa.service.ServicioPromocion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioPromocion implements ServicioPromocion {
    private final RepoPromocion repoPromocion;

    @Override
    public DtoPromocion crearPromocion(DtoPromocion dtoPromocion) {
        Promocion promocion = MapperPromocion.mapAPromocion(dtoPromocion);
        Promocion salvadaPromocion = repoPromocion.save(promocion);
        return MapperPromocion.mapADtoPromocion(salvadaPromocion);
    }

    @Override
    public DtoPromocion getPromocion(Integer promocionId) {
        Promocion promocion = repoPromocion.findById(promocionId)
                .orElseThrow(() -> new ResourceNotFoundException("Promocion no encontrada: " + promocionId));
        return MapperPromocion.mapADtoPromocion(promocion);
    }

    @Override
    public List<DtoPromocion> getAllPromociones() {
        List<Promocion> promociones = repoPromocion.findAll();
        return promociones.stream()
                .map(MapperPromocion::mapADtoPromocion)
                .collect(Collectors.toList());
    }

    @Override
    public DtoPromocion updatePromocion(Integer promocion_id, DtoPromocion updatePromocion) {
        Promocion promocion = repoPromocion.findById(promocion_id)
                .orElseThrow(() -> new ResourceNotFoundException("Promocion no encontrada con id: " + promocion_id));

        promocion.setNombre(updatePromocion.getNombre());
        promocion.setDescripcion(updatePromocion.getDescripcion());
        promocion.setDescuento(updatePromocion.getDescuento());
        promocion.setFechaInicio(updatePromocion.getFechaInicio());
        promocion.setFechaFin(updatePromocion.getFechaFin());
        promocion.setTipo(updatePromocion.getTipo());

        Promocion updatedPromocionObj = repoPromocion.save(promocion);
        return MapperPromocion.mapADtoPromocion(updatedPromocionObj);
    }

    @Override
    public void deletePromocion(Integer promocion_id) {
        Promocion promocion = repoPromocion.findById(promocion_id)
                .orElseThrow(() -> new ResourceNotFoundException("Promocion no encontrada con id: " + promocion_id));

        repoPromocion.deleteById(promocion_id);
    }
}