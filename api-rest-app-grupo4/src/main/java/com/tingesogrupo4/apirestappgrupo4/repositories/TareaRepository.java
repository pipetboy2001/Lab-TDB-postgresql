package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.Institucion;
import com.tingesogrupo4.apirestappgrupo4.models.Tarea;

import java.util.List;

public interface TareaRepository {
    //Generacion de firmas para consumir desde services.


    Tarea createTarea(Tarea tarea);
    Tarea getTareaById(Integer id);

    List<Tarea> getAllTareas();
    Tarea updateTarea(Tarea tarea);
    void deleteTareaById(Integer id);

    void deleteTareas();

    Integer generateIdTarea();

}
