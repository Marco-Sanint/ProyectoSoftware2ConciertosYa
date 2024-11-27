package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.entity.Lugar;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperLugar;
import com.proyectoSoftware.conciertosYa.repository.RepoLugar;
import com.proyectoSoftware.conciertosYa.service.ServicioLugar;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioLugar implements ServicioLugar {

    private final RepoLugar repoLugar;

    @Override
    public DtoLugar crearLugar(DtoLugar dtoLugar) {
        Lugar lugar = MapperLugar.mapALugar(dtoLugar);
        Lugar salvadoLugar = repoLugar.save(lugar);
        return MapperLugar.mapADtoLugar(salvadoLugar);
    }

    @Override
    public DtoLugar getLugar(Integer lugar_id) {
        Lugar lugar = repoLugar.findById(lugar_id)
                .orElseThrow(() -> new ResourceNotFoundException("Lugar no encontrado: " + lugar_id));
        return MapperLugar.mapADtoLugar(lugar);
    }

    @Override
    public List<DtoLugar> getAllLugares() {
        List<Lugar> lugares = repoLugar.findAll();
        return lugares.stream()
                .map(MapperLugar::mapADtoLugar)
                .collect(Collectors.toList());
    }

    @Override
    public DtoLugar updateLugar(Integer lugar_id, DtoLugar updateLugar) {
        Lugar lugar = repoLugar.findById(lugar_id)
                .orElseThrow(() -> new ResourceNotFoundException("Lugar no encontrado: " + lugar_id));

        lugar.setNombre(updateLugar.getNombre());
        lugar.setDireccion(updateLugar.getDireccion());
        lugar.setCapacidad(updateLugar.getCapacidad());
        lugar.setCiudad(updateLugar.getCiudad());
        lugar.setImagen(updateLugar.getImagen());

        Lugar actualizado = repoLugar.save(lugar);
        return MapperLugar.mapADtoLugar(actualizado);
    }

    @Override
    public void deleteLugar(Integer lugar_id) {
        Lugar lugar = repoLugar.findById(lugar_id)
                .orElseThrow(() -> new ResourceNotFoundException("Lugar no encontrado: " + lugar_id));
        repoLugar.delete(lugar);
    }
}