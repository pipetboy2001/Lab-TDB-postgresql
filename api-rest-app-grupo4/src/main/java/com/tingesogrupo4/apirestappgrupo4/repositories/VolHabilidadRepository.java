package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.VolHabilidad;

import java.util.List;

public interface VolHabilidadRepository{
    Integer generateId();
    VolHabilidad createVolHabilidad(VolHabilidad volHabilidad);

    VolHabilidad getVolHabilidadById(Integer id);
    List<VolHabilidad> getAllVolHabilidad();
    VolHabilidad updateVolHabilidad(VolHabilidad volHabilidad);
    void deleteVolHabilidadById(Integer id);
    void deleteAllVolHabilidades();

}
