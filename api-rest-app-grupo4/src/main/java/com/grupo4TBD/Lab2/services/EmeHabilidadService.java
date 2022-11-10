package com.grupo4TBD.Lab2.services;

import com.grupo4TBD.Lab2.repositories.EmeHabilidadRepository;
import com.grupo4TBD.Lab2.models.EmeHabilidad;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")

public class EmeHabilidadService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final EmeHabilidadRepository emeHabilidadRepository;
    public EmeHabilidadService(EmeHabilidadRepository emeHabilidadRepository) {
        this.emeHabilidadRepository = emeHabilidadRepository;
    }

    @PostMapping("/emehabilidades")
    public EmeHabilidad createEmergencia(@RequestBody EmeHabilidad emeHabilidad){
        System.out.println("Intento posting emergencia...");
        return emeHabilidadRepository.createEmeHabilidad(emeHabilidad);
    }
    @GetMapping("/emehabilidades/{id}")
    public EmeHabilidad getEmeHabilidadById(@PathVariable Integer id){
        return emeHabilidadRepository.getEmeHabilidadById(id);
    }

    @GetMapping("/emehabilidades")
    public List<EmeHabilidad> getAllEmeHabilidad(){
        return emeHabilidadRepository.getAllEmeHabilidad();

    }
    @PutMapping("/emehabilidades")
    public EmeHabilidad updateEmeHabilidad(@RequestBody EmeHabilidad emeHabilidad){
        return emeHabilidadRepository.updateEmeHabilidad(emeHabilidad);
    }

    @DeleteMapping("/emehabilidades/{id}")
    public void deleteEmeHabilidadById(@PathVariable Integer id){
        emeHabilidadRepository.deleteEmeHabilidadById(id);
    }

    @DeleteMapping("/emehabilidades")
    public void deleteEmeHabilidad(){
        emeHabilidadRepository.deleteEmeHabilidad();
    }

}
