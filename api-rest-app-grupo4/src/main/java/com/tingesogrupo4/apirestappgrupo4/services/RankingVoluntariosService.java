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

    private final RankingVoluntariosRepository rankingVoluntariosRepository;


    public RankingVoluntariosService(RankingVoluntariosRepository rkvR) {
        this.rankingVoluntariosRepository = rkvR;
    }

    @PostMapping("/ranking/voluntarios")
    public RankingVoluntarios createRankingVoluntario(@RequestBody RankingVoluntarios RKV){
        System.out.println("Intento posting ranking voluntarios...");
        return rankingVoluntariosRepository.createRankingVoluntario(RKV);
    }

    @GetMapping("/ranking/voluntarios/{id}")
    public RankingVoluntarios getRankingVoluntarioById(@PathVariable Integer id){
        return rankingVoluntariosRepository.getRankingVoluntario(id);
    }

    @GetMapping("/ranking/voluntarios")
    public List<RankingVoluntarios> getAllRankingVoluntarios(){
        return rankingVoluntariosRepository.getAllRankingVoluntario();
    }

    @PutMapping("/ranking/voluntarios")
    public RankingVoluntarios updateRankingVoluntario(@RequestBody RankingVoluntarios RKV){
        return rankingVoluntariosRepository.updateRankingVoluntario(RKV);
    }

    @DeleteMapping("/ranking/voluntarios/{id}")
    public void deleteRankingVoluntarioById(@PathVariable Integer id){
        rankingVoluntariosRepository.deleteRankingVoluntarioById(id);
    }


}
