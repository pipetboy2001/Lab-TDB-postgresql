package com.tingesogrupo4.apirestappgrupo4.services;

import com.tingesogrupo4.apirestappgrupo4.models.Emergencia;
import com.tingesogrupo4.apirestappgrupo4.models.Ranking;
import com.tingesogrupo4.apirestappgrupo4.repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RankingService {

    RankingRepository rankingRepository;
    @PostMapping("/ranking/create")
    public Ranking createRanking(@RequestBody Ranking ranking){
        System.out.println("Intento posting ranking...");
        return rankingRepository.createRanking(ranking);
    }
    @GetMapping("/ranking/{id}")
    public Ranking getRankingById(@PathVariable Integer id){
        return rankingRepository.getRankingById(id);
    }

    @GetMapping("/ranking")
    public List<Ranking> getAllRanking(){
        return rankingRepository.getAllRankings();
    }

    @PutMapping("/ranking/{id}")
    public Ranking updateRanking(@RequestBody Ranking ranking){
        return rankingRepository.updateRanking(ranking);
    }

    @DeleteMapping("/ranking/{id}")
    public void deleteRankingById(@PathVariable Integer id){
        rankingRepository.deleteRankingById(id);
    }

    @DeleteMapping("/ranking")
    public void deleteRanking(){
        rankingRepository.deleteRanking();
    }

}
