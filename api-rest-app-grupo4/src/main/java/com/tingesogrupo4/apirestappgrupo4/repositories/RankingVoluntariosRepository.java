package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.RankingVoluntarios;

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
