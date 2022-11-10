package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.RankingVoluntarios;

import java.util.List;

public interface RankingVoluntariosRepository {

    Integer generateIdRankingVoluntarios();
    RankingVoluntarios createRankingVoluntario(RankingVoluntarios RKV);

    RankingVoluntarios getRankingVoluntario(Integer id);

    List<RankingVoluntarios> getAllRankingVoluntario();

    RankingVoluntarios updateRankingVoluntario(RankingVoluntarios RKV);
    void deleteRankingVoluntarioById(Integer id);
    void deleteRankingVoluntario();


}
