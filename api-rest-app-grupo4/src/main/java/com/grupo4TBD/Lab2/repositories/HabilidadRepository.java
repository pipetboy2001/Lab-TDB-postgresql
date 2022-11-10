package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.Habilidad;

import java.util.List;

public interface HabilidadRepository {
     Integer generateId();
     Habilidad createHabilidad(Habilidad habilidad);
     Habilidad getHabilidadById(Integer id);
     List<Habilidad> getAllHabilidad();

     Habilidad updateHabilidad(Habilidad habilidad);
     void deleteHabilidadById(Integer id);
     void deleteHabilidades();

}
