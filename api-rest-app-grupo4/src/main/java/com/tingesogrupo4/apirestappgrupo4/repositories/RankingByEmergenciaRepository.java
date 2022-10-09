package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.RankingByEmergencia;

import java.util.List;

public interface RankingByEmergenciaRepository {
    List<RankingByEmergencia> getRankingByEmergenciaId(Integer id_tarea);

}
