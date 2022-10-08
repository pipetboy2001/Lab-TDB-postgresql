package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.EstadoTarea;

import java.util.List;

public interface EstadoTareaRepository{
    Integer generateId();
    EstadoTarea createEstadoTarea(EstadoTarea estadoTarea);
    EstadoTarea getEstadoTareaById(Integer id);
    List<EstadoTarea> getAllEstadoTarea();
    EstadoTarea updateEstadoTarea(EstadoTarea estadoTarea);
    void deleteEstadoTareaById(Integer id);
    void deleteEstadoTarea();


}
