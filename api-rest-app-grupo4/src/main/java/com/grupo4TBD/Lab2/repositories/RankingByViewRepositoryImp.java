package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.RankingByView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Component
@Configuration
@Repository
public class RankingByViewRepositoryImp implements RankingByViewRepository {
    @Autowired
    private Sql2o sql2o;


    @Override
    public List<RankingByView> generateRankingByView() {
        System.out.println("Entro a generar ranking view");
        final String query = "select foo.id_voluntario, voluntario.nombre,foo.cantidad from " +
                "(select count(ranking.id_voluntario) as cantidad, ranking.id_voluntario from tareas_emergencia " +
                "inner join ranking on tareas_emergencia.id_tarea = ranking.id_tarea  group by ranking.id_voluntario) as foo, voluntario " +
                "where voluntario.id = foo.id_voluntario";
        final List<RankingByView> rankingByViewList;
        Connection conn = sql2o.open();
        try (conn) {
            System.out.println(query + "<-Query");
            rankingByViewList = conn.createQuery(query)
                    .executeAndFetch(RankingByView.class);
            return rankingByViewList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conn.close();
        }

    }

}
