package com.tingesogrupo4.apirestappgrupo4.services;


import com.tingesogrupo4.apirestappgrupo4.models.Ranking;
import com.tingesogrupo4.apirestappgrupo4.models.RankingVoluntarios;
import com.tingesogrupo4.apirestappgrupo4.repositories.RankingVoluntariosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value ="/")
public class RankingVoluntariosService {
    //Se hace uso de REST para la implementacion de las direciones para obtener los servicios.
    private final RankingVoluntariosRepository rankingVoluntariosRepository;


    public RankingVoluntariosService(RankingVoluntariosRepository rkvR) {
        this.rankingVoluntariosRepository = rkvR;
    }

    @PostMapping("/ranking_voluntariados")
    public RankingVoluntarios createRankingVoluntario(@RequestBody RankingVoluntarios RKV){
        System.out.println(RKV);
        System.out.println("Intento posting ranking voluntarios...");
        return rankingVoluntariosRepository.createRankingVoluntario(RKV);
    }

    @GetMapping("/ranking_voluntariados/{id}")
    public RankingVoluntarios getRankingVoluntarioById(@PathVariable Integer id){
        return rankingVoluntariosRepository.getRankingVoluntario(id);
    }

    @GetMapping("/ranking_voluntariados")
    public List<RankingVoluntarios> getAllRankingVoluntarios(){
        return rankingVoluntariosRepository.getAllRankingVoluntario();
    }

    @PutMapping("/ranking_voluntariados")
    public RankingVoluntarios updateRankingVoluntario(@RequestBody RankingVoluntarios RKV){
        return rankingVoluntariosRepository.updateRankingVoluntario(RKV);
    }

    @DeleteMapping("/ranking_voluntariados/{id}")
    public void deleteRankingVoluntarioById(@PathVariable Integer id){
        rankingVoluntariosRepository.deleteRankingVoluntarioById(id);
    }


}
