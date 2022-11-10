package com.grupo4TBD.Lab2.services;


import com.grupo4TBD.Lab2.repositories.VolHabilidadRepository;
import com.grupo4TBD.Lab2.models.VolHabilidad;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")

public class VolHabilidadService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final VolHabilidadRepository volHabilidadRepository;
    public VolHabilidadService(VolHabilidadRepository volHabilidadRepository) {
        this.volHabilidadRepository = volHabilidadRepository;
    }


    @PostMapping("/volhabilidades")
    public VolHabilidad createVolHabilidad(@RequestBody VolHabilidad volHabilidad){
        System.out.println("Intento posting emergencia...");
        return volHabilidadRepository.createVolHabilidad(volHabilidad);
    }
    @GetMapping("/volhabilidades/{id}")
    public VolHabilidad getVolHabilidadById(@PathVariable Integer id){
        return volHabilidadRepository.getVolHabilidadById(id);
    }

    @GetMapping("/volhabilidades")
    public List<VolHabilidad> getAllVolHabilidad(){
        return volHabilidadRepository.getAllVolHabilidad();

    }
    @PutMapping("/volhabilidades")
    public VolHabilidad updateEmeHabilidad(@RequestBody VolHabilidad volHabilidad){
        return volHabilidadRepository.updateVolHabilidad(volHabilidad);
    }

    @DeleteMapping("/volhabilidades/{id}")
    public void deleteEmeHabilidadById(@PathVariable Integer id){
        volHabilidadRepository.deleteVolHabilidadById(id);
    }

    @DeleteMapping("/volhabilidades")
    public void deleteEmeHabilidad(){
        volHabilidadRepository.deleteAllVolHabilidades();
    }




}
