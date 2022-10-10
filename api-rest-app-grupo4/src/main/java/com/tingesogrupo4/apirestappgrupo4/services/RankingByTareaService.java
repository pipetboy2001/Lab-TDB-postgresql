package com.tingesogrupo4.apirestappgrupo4.services;

import com.tingesogrupo4.apirestappgrupo4.models.RankingByTarea;
import com.tingesogrupo4.apirestappgrupo4.repositories.RankingByTareaRepository;
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
