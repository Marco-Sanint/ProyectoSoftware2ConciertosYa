package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoLugar;
import com.proyectoSoftware.conciertosYa.entity.Lugar;
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

    public ImplServicioLugar(RepoLugar repoLugar) {
        this.repoLugar = repoLugar;
    }

    @Override
    public DtoLugar crearLugar(DtoLugar dtoLugar) {
        Lugar lugar = MapperLugar.mapALugar(dtoLugar);
        Lugar lugarGuardado = repoLugar.save(lugar);
        return MapperLugar.mapADtoLugar(lugarGuardado);
    }

    @Override
    public DtoLugar obtenerLugar(Integer id) {
        Lugar lugar = repoLugar.findById(id)
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));
        return MapperLugar.mapADtoLugar(lugar);
    }

    @Override
    public DtoLugar actualizarLugar(Integer id, DtoLugar dtoLugar) {
        Lugar lugar = repoLugar.findById(id)
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));
        lugar.setNombre(dtoLugar.getNombre());
        lugar.setDireccion(dtoLugar.getDireccion());
        lugar.setCapacidad(dtoLugar.getCapacidad());
        lugar.setCiudad(dtoLugar.getCiudad());
        lugar.setImagen(dtoLugar.getImagen());
        Lugar lugarActualizado = repoLugar.save(lugar);
        return MapperLugar.mapADtoLugar(lugarActualizado);
    }

    @Override
    public void eliminarLugar(Integer id) {
        Lugar lugar = repoLugar.findById(id)
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));
        repoLugar.delete(lugar);
    }

    @Override
    public List<DtoLugar> listarLugares() {
        return repoLugar.findAll().stream()
                .map(MapperLugar::mapADtoLugar)
                .collect(Collectors.toList());
    }
}
