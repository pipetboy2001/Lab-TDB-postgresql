package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.VolHabilidad;

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
