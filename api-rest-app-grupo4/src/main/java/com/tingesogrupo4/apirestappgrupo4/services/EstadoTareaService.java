package com.tingesogrupo4.apirestappgrupo4.services;

import com.tingesogrupo4.apirestappgrupo4.models.Emergencia;
import com.tingesogrupo4.apirestappgrupo4.models.EstadoTarea;
import com.tingesogrupo4.apirestappgrupo4.repositories.EstadoTareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class EstadoTareaService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final EstadoTareaRepository estadoTareaRepository;
    public EstadoTareaService(EstadoTareaRepository estadoTareaRepository) {
        this.estadoTareaRepository = estadoTareaRepository;
    }

    @PostMapping("/estadotareas")
    public void createEstadoTarea(@RequestBody EstadoTarea estadoTarea){
        estadoTareaRepository.createEstadoTarea(estadoTarea);
    }
    @GetMapping("/estadotareas/{id}")
    public EstadoTarea getEstadoTareaById(@PathVariable Integer id){
        return estadoTareaRepository.getEstadoTareaById(id);
    }

    @GetMapping("/estadotareas")
    public List<EstadoTarea> getAllEstadoTareas(){
        return estadoTareaRepository.getAllEstadoTarea();
    }

    @PutMapping("/estadotareas")
    public EstadoTarea updateEstadoTarea(@RequestBody EstadoTarea estadoTarea){
        return estadoTareaRepository.updateEstadoTarea(estadoTarea);
    }

    @DeleteMapping("/estadotareas/{id}")
    public void deleteEstadoTareaById(@PathVariable Integer id){
        estadoTareaRepository.deleteEstadoTareaById(id);
    }

    @DeleteMapping("/estadotareas")
    public void deleteEstadoTareas(){
        estadoTareaRepository.deleteEstadoTarea();
    }


}
