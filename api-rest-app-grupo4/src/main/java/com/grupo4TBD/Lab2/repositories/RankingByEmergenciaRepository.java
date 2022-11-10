package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.RankingByEmergencia;

import java.util.List;

public interface RankingByEmergenciaRepository {
    List<RankingByEmergencia> getRankingByEmergenciaId(Integer id_tarea);

}
