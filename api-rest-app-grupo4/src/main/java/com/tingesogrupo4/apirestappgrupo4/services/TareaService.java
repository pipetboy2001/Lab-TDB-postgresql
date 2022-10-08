package com.tingesogrupo4.apirestappgrupo4.services;


import com.tingesogrupo4.apirestappgrupo4.models.Institucion;
import com.tingesogrupo4.apirestappgrupo4.models.Tarea;
import com.tingesogrupo4.apirestappgrupo4.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class TareaService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @PostMapping("/tareas")
    public Tarea createTarea(@RequestBody Tarea tarea){
        System.out.println("Intento posting tarea...");
        return tareaRepository.createTarea(tarea);
    }
    @GetMapping("/tareas/{id}")
    public Tarea getInstitucionById(@PathVariable Integer id){
        return tareaRepository.getTareaById(id);
    }

    @GetMapping("/tareas")
    public List<Tarea> getAllTareas(){
        return tareaRepository.getAllTareas();

    }
    @PutMapping("/tareas")
    public Tarea updateTarea(@RequestBody Tarea tarea){
        return tareaRepository.updateTarea(tarea);
    }

    @DeleteMapping("/tareas/{id}")
    public void deleteTareaById(@PathVariable Integer id){
        tareaRepository.deleteTareaById(id);
    }

    @DeleteMapping("/tareas")
    public void deleteTareas(){
        tareaRepository.deleteTareas();
    }




}