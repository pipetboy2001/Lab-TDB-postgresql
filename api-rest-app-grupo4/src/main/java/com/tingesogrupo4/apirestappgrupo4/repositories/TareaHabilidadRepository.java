package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.TareaHabilidad;

import java.util.List;

public interface TareaHabilidadRepository {
    Integer generateId();
    TareaHabilidad createTareaHabilidad(TareaHabilidad tareaHabilidad);
    TareaHabilidad getTareaHabilidadById(Integer id);

    List<TareaHabilidad> getAllTareaHabilidad();
    TareaHabilidad updateTareaHabilidad(TareaHabilidad tareaHabilidad);
    void deleteTareaHabilidadById(Integer id);
    void deleteTareaHabilidad();


}
