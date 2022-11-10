package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.RankingByEmergencia;
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

public class RankingByEmergenciaRepositoryImp implements RankingByEmergenciaRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<RankingByEmergencia> getRankingByEmergenciaId(Integer id_emergencia) {
        final String query = "select nombre, req_cumplidos, id_voluntario\n" +
                "from (select count(id_voluntario) as req_cumplidos, id_voluntario \n" +
                "from eme_habilidad\n" +
                "inner join vol_habilidad on vol_habilidad.id_habilidad = eme_habilidad.id_habilidad \n" +
                "where id_emergencia =:id_emergencia\n" +
                "group by id_voluntario) as cumplidos, voluntario\n" +
                "where voluntario.id = cumplidos.id_voluntario\n" +
                "order by req_cumplidos desc";
        final List<RankingByEmergencia> rankingByEmergenciaList;
        Connection conn = sql2o.open();
        try(conn){
            rankingByEmergenciaList = conn.createQuery(query)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetch(RankingByEmergencia.class);
            return rankingByEmergenciaList;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

}
