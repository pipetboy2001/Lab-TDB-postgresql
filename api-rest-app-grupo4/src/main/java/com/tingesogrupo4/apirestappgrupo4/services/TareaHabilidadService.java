package com.tingesogrupo4.apirestappgrupo4.services;

import com.tingesogrupo4.apirestappgrupo4.models.TareaHabilidad;
import com.tingesogrupo4.apirestappgrupo4.repositories.TareaHabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class TareaHabilidadService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final TareaHabilidadRepository tareaHabilidadRepository;
    public TareaHabilidadService(TareaHabilidadRepository tareaHabilidadRepository) {
        this.tareaHabilidadRepository = tareaHabilidadRepository;
    }
    @PostMapping("/tareahabilidades")
    public void createTareaHabilidad(@RequestBody TareaHabilidad tareaHabilidad){
        tareaHabilidadRepository.createTareaHabilidad(tareaHabilidad);
    }
    @GetMapping("/tareahabilidades/{id}")
    public TareaHabilidad getTareaHabilidad(@PathVariable Integer id){
        return tareaHabilidadRepository.getTareaHabilidadById(id);
    }

    @GetMapping("/tareahabilidades")
    public List<TareaHabilidad> getAllTareaHabilidad(){
        return tareaHabilidadRepository.getAllTareaHabilidad();

    }
    @PutMapping("/tareahabilidades")
    public TareaHabilidad updateTareaHabilidad(@RequestBody TareaHabilidad tareaHabilidad){
        return tareaHabilidadRepository.updateTareaHabilidad(tareaHabilidad);
    }

    @DeleteMapping("/tareahabilidades/{id}")
    public void deleteTareaHabilidadById(@PathVariable Integer id){
        tareaHabilidadRepository.deleteTareaHabilidadById(id);
    }

    @DeleteMapping("/tareahabilidades")
    public void deleteTareaHabilidad(){
        tareaHabilidadRepository.deleteTareaHabilidad();
    }

}
