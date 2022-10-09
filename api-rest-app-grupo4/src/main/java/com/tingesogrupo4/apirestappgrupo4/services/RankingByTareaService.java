package com.tingesogrupo4.apirestappgrupo4.services;

import com.tingesogrupo4.apirestappgrupo4.models.RankingByTarea;
import com.tingesogrupo4.apirestappgrupo4.repositories.RankingByTareaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class RankingByTareaService {
    private final RankingByTareaRepository rankingByTareaRepository;
    public RankingByTareaService(RankingByTareaRepository rankingByTareaRepository) {
        this.rankingByTareaRepository = rankingByTareaRepository;
    }

    @GetMapping("/ranking-tareas")
    public List<RankingByTarea> getRankingByTarea(){
        return rankingByTareaRepository.getRankingByTarea();

    }


}
