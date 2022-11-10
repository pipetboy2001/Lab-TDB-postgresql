package com.grupo4TBD.Lab2.services;


import com.grupo4TBD.Lab2.repositories.HabilidadRepository;
import com.grupo4TBD.Lab2.models.Habilidad;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class HabilidadService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final HabilidadRepository habilidadRepository;

    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    @PostMapping("/habilidades")
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        System.out.println("Intento posting...");
        return habilidadRepository.createHabilidad(habilidad);
    }

    @GetMapping("/habilidades/{id}")
    public Habilidad getHabilidadById(@PathVariable Integer id){
        return habilidadRepository.getHabilidadById(id);
    }

    @GetMapping("/habilidades")
    public List<Habilidad> getAllHabilidades(){
        return habilidadRepository.getAllHabilidad();
    }

    @PutMapping("/habilidades")
    public Habilidad updateHabilidades(@RequestBody Habilidad habilidad){
        return habilidadRepository.updateHabilidad(habilidad);
    }

    @DeleteMapping("/habilidades/{id}")
    public void deleteHabilidadById(@PathVariable Integer id){
         habilidadRepository.deleteHabilidadById(id);
    }

    @DeleteMapping("/habilidades")
    public void deleteHabilidades(){
        habilidadRepository.deleteHabilidades();
    }


}
