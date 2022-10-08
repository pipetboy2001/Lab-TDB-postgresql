package com.tingesogrupo4.apirestappgrupo4.services;

import com.tingesogrupo4.apirestappgrupo4.models.EmeHabilidad;
import com.tingesogrupo4.apirestappgrupo4.models.Emergencia;
import com.tingesogrupo4.apirestappgrupo4.repositories.EmeHabilidadRepository;
import com.tingesogrupo4.apirestappgrupo4.repositories.EmergenciaRepository;
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

    @PostMapping("/emehabilidad")
    public EmeHabilidad createEmergencia(@RequestBody EmeHabilidad emeHabilidad){
        System.out.println("Intento posting emergencia...");
        return emeHabilidadRepository.createEmeHabilidad(emeHabilidad);
    }
    @GetMapping("/emehabilidad/{id}")
    public EmeHabilidad getEmeHabilidadById(@PathVariable Integer id){
        return emeHabilidadRepository.getEmeHabilidadById(id);
    }

    @GetMapping("/emehabilidad")
    public List<EmeHabilidad> getAllEmeHabilidad(){
        return emeHabilidadRepository.getAllEmeHabilidad();

    }
    @PutMapping("/emehabilidad")
    public EmeHabilidad updateEmeHabilidad(@RequestBody EmeHabilidad emeHabilidad){
        return emeHabilidadRepository.updateEmeHabilidad(emeHabilidad);
    }

    @DeleteMapping("/emehabilidad/{id}")
    public void deleteEmeHabilidadById(@PathVariable Integer id){
        emeHabilidadRepository.deleteEmeHabilidadById(id);
    }

    @DeleteMapping("/emehabilidad")
    public void deleteEmeHabilidad(){
        emeHabilidadRepository.deleteEmeHabilidad();
    }

}
