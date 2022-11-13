package com.grupo4TBD.Lab2.services;

import com.grupo4TBD.Lab2.models.RankingByView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class RankingByViewService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final com.grupo4TBD.Lab2.repositories.RankingByViewRepository RankingByViewRepository;
    RankingByViewService(com.grupo4TBD.Lab2.repositories.RankingByViewRepository RankingByViewRepository){
        this.RankingByViewRepository = RankingByViewRepository;
    }

    @GetMapping("/rankingbyview")
    public List<RankingByView> getAllRankingByView(){
        return RankingByViewRepository.generateRankingByView();

    }

}
