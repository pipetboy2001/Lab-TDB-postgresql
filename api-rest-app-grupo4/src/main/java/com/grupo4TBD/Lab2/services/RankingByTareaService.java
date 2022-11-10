package com.grupo4TBD.Lab2.services;

import com.grupo4TBD.Lab2.repositories.RankingByTareaRepository;
import com.grupo4TBD.Lab2.models.RankingByTarea;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class RankingByTareaService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final RankingByTareaRepository rankingByTareaRepository;
    public RankingByTareaService(RankingByTareaRepository rankingByTareaRepository) {
        this.rankingByTareaRepository = rankingByTareaRepository;
    }

    @GetMapping("/ranking-tareas")
    public List<RankingByTarea> getRankingByTarea(){
        return rankingByTareaRepository.getRankingByTarea();

    }
    @GetMapping("/ranking-tareas/{id}")
    public List<RankingByTarea> getRankingByTareaId(@PathVariable Integer id){
        return rankingByTareaRepository.getRankingByTareaId(id);
    }


}
