package com.tingesogrupo4.apirestappgrupo4.services;


import com.tingesogrupo4.apirestappgrupo4.models.Institucion;
import com.tingesogrupo4.apirestappgrupo4.repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class InstitucionService {

    private final InstitucionRepository institucionRepository;
    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @PostMapping("/instituciones")
    public Institucion createInstitucion(@RequestBody Institucion institucion){
        System.out.println("Intento posting...");
        return institucionRepository.createInstitucion(institucion);
    }


    @PostMapping("/instituciones/newidtest")
    public int newId(){

        System.out.println("Intento newId...");
        int myId = newId();

        System.out.println("el max id es = "+myId);

        return myId;
    }
    @GetMapping("/instituciones/{id}")
    public Institucion getInstitucionById(@PathVariable Integer id){
        return institucionRepository.getInstitucionById(id);
    }

    @GetMapping("/instituciones")
    public List<Institucion> getAllInstituciones(){
        return institucionRepository.getAllInstituciones();

    }
    @PutMapping("/instituciones")
    public Institucion updateInstituciones(@RequestBody Institucion institucion){
        return institucionRepository.updateInstitucion(institucion);
    }

    @DeleteMapping("/instituciones/{id}")
    public void deleteInstitucionById(@PathVariable Integer id){
         institucionRepository.deleteInstitucionById(id);
    }

    @DeleteMapping("/instituciones")
    public void deleteInstituciones(){
        institucionRepository.deleteInstitucion();
    }

}
