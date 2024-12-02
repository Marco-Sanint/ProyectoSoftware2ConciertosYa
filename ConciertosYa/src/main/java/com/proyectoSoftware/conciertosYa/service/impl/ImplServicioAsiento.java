
package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import com.proyectoSoftware.conciertosYa.exception.ResourceNotFoundException;
import com.proyectoSoftware.conciertosYa.mapper.MapperAsiento;
import com.proyectoSoftware.conciertosYa.repository.RepoAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImplServicioAsiento implements ServicioAsiento {
    private RepoAsiento repoAsiento;

    @Override
    public DtoAsiento crearAsiento(DtoAsiento dtoAsiento) {

        Asiento asiento = MapperAsiento.mapAAsiento(dtoAsiento);
        Asiento salvarAsiento = repoAsiento.save(asiento);
        return MapperAsiento.mapADtoAsiento(salvarAsiento);
    }

    @Override
    public DtoAsiento getAsiento(Integer asientoId) {
        Asiento asiento = repoAsiento.findById(asientoId)
                .orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado: " + asientoId));

        return MapperAsiento.mapADtoAsiento(asiento);
    }


    @Override
    public List<DtoAsiento> getAllAsiento() {
        List<Asiento> asientos = repoAsiento.findAll();
        return asientos.stream().map((asiento) -> MapperAsiento.mapADtoAsiento(asiento)).collect(Collectors.toList());
    }

    @Override
    public DtoAsiento updateAsiento(Integer asiento_id, DtoAsiento updateAsiento) {
        Asiento asiento = repoAsiento.findById(asiento_id).orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado con id: " + asiento_id));

        asiento.setCodigo(updateAsiento.getCodigo());
        asiento.setColumna(updateAsiento.getColumna());
        asiento.setPrecio(updateAsiento.getPrecio());
        asiento.setTipo(updateAsiento.getTipo());
        asiento.setEstado(updateAsiento.getEstado());

        Asiento updateAsientoObj = repoAsiento.save(asiento);

        return MapperAsiento.mapADtoAsiento(updateAsientoObj);
    }

    @Override
    public void deleteAsiento(Integer asiento_id) {
        Asiento asiento = repoAsiento.findById(asiento_id).orElseThrow(() -> new ResourceNotFoundException("Asiento no encontrado con id: " + asiento_id));

        repoAsiento.deleteById(asiento_id);
    }
}