package com.grupo4TBD.Lab2.services;


import com.grupo4TBD.Lab2.models.RankingByEmergencia;
import com.grupo4TBD.Lab2.repositories.RankingByEmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class RankingByEmergenciaService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final RankingByEmergenciaRepository rankingByEmergenciaRepository;
    RankingByEmergenciaService(RankingByEmergenciaRepository rankingByEmergenciaRepository){
        this.rankingByEmergenciaRepository = rankingByEmergenciaRepository;
    }

    @GetMapping("/ranking-emergencias/{id}")
    public List<RankingByEmergencia> getRankingByEmergencia(@PathVariable Integer id){
        return rankingByEmergenciaRepository.getRankingByEmergenciaId(id);
    }


}
