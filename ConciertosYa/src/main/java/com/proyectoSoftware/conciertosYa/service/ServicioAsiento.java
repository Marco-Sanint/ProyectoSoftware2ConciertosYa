
package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.dto.DtoCliente;

import java.util.List;

public interface ServicioAsiento {
    DtoAsiento crearAsiento(DtoAsiento dtoAsiento);

    DtoAsiento getAsiento(Integer asiento_id);

    List<DtoAsiento> getAllAsiento();

    DtoAsiento updateAsiento(Integer asiento_id, DtoAsiento updateAsiento);

    void deleteAsiento(Integer asiento_id);
}
