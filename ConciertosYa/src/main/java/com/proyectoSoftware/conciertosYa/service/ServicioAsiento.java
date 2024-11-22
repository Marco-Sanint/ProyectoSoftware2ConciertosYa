
package com.proyectoSoftware.conciertosYa.service;

import com.proyectoSoftware.conciertosYa.dto.DtoAsiento;
import com.proyectoSoftware.conciertosYa.dto.DtoCliente;

public interface ServicioAsiento {
    DtoAsiento crearAsiento(DtoAsiento dtoAsiento);

    DtoAsiento getAsiento(Integer asientoId);
}
