package com.proyectoSoftware.conciertosYa.service.impl;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.entity.Asiento;
import com.proyectoSoftware.conciertosYa.mapper.MapperAsiento;
import com.proyectoSoftware.conciertosYa.repository.RepoAsiento;
import com.proyectoSoftware.conciertosYa.service.ServicioAsiento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
