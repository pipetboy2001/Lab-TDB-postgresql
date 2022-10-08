package com.tingesogrupo4.apirestappgrupo4.services;

import com.tingesogrupo4.apirestappgrupo4.models.Emergencia;
import com.tingesogrupo4.apirestappgrupo4.repositories.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class EmergenciaService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final EmergenciaRepository emergenciaRepository;
    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    @PostMapping("/emergencia")
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        System.out.println("Intento posting emergencia...");
        return emergenciaRepository.createEmergencia(emergencia);
    }
    @GetMapping("/emergencia/{id}")
    public Emergencia getEmergenciaById(@PathVariable Integer id){
        return emergenciaRepository.getEmergenciaById(id);
    }

    @GetMapping("/emergencia")
    public List<Emergencia> getAllEmergencia(){
        return emergenciaRepository.getAllEmergencia();
    }
    @PutMapping("/emergencia")
    public Emergencia updateEmergencia(@RequestBody Emergencia emergencia){
        return emergenciaRepository.updateEmergencia(emergencia);
    }

    @DeleteMapping("/emergencia/{id}")
    public void deleteEmergenciaById(@PathVariable Integer id){
        emergenciaRepository.deleteEmergenciaById(id);
    }

    @DeleteMapping("/emergencia")
    public void deleteEmergencia(){
        emergenciaRepository.deleteEmergencia();
    }


}
