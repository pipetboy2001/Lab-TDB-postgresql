package com.tingesogrupo4.apirestappgrupo4.services;


import com.tingesogrupo4.apirestappgrupo4.models.RankingByEmergencia;
import com.tingesogrupo4.apirestappgrupo4.models.RankingByTarea;
import com.tingesogrupo4.apirestappgrupo4.repositories.InstitucionRepository;
import com.tingesogrupo4.apirestappgrupo4.repositories.RankingByEmergenciaRepository;
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
