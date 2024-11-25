package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoPromocion;
import com.proyectoSoftware.conciertosYa.entity.Promocion;
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

    public ImplServicioPromocion(RepoPromocion repoPromocion) {
        this.repoPromocion = repoPromocion;
    }

    @Override
    public DtoPromocion crearPromocion(DtoPromocion dtoPromocion) {
        Promocion promocion = MapperPromocion.mapAPromocion(dtoPromocion);
        Promocion promocionGuardada = repoPromocion.save(promocion);
        return MapperPromocion.mapADtoPromocion(promocionGuardada);
    }

    @Override
    public DtoPromocion obtenerPromocion(Integer id) {
        Promocion promocion = repoPromocion.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));
        return MapperPromocion.mapADtoPromocion(promocion);
    }

    @Override
    public List<DtoPromocion> listarPromociones() {
        return repoPromocion.findAll().stream()
                .map(MapperPromocion::mapADtoPromocion)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoPromocion> listarPromocionesPorTipo(String tipo) {
        return repoPromocion.findByTipo(tipo).stream()
                .map(MapperPromocion::mapADtoPromocion)
                .collect(Collectors.toList());
    }

    @Override
    public DtoPromocion actualizarPromocion(Integer id, DtoPromocion dtoPromocion) {
        Promocion promocion = repoPromocion.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));
        promocion.setNombre(dtoPromocion.getNombre());
        promocion.setDescripcion(dtoPromocion.getDescripcion());
        promocion.setDescuento(dtoPromocion.getDescuento());
        promocion.setFechaInicio(dtoPromocion.getFechaInicio());
        promocion.setFechaFin(dtoPromocion.getFechaFin());
        promocion.setTipo(Promocion.TipoPromocion.valueOf(dtoPromocion.getTipo()));
        Promocion promocionActualizada = repoPromocion.save(promocion);
        return MapperPromocion.mapADtoPromocion(promocionActualizada);
    }

    @Override
    public void eliminarPromocion(Integer id) {
        Promocion promocion = repoPromocion.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));
        repoPromocion.delete(promocion);
    }
}
