package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.RankingByTarea;

import java.util.List;

public interface RankingByTareaRepository {
    List<RankingByTarea> getRankingByTarea();
    List<RankingByTarea> getRankingByTareaId(Integer id_tarea);
}
