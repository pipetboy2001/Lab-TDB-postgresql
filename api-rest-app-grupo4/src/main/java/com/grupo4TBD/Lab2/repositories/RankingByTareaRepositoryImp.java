package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.RankingByTarea;
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
public class RankingByTareaRepositoryImp implements RankingByTareaRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<RankingByTarea> getRankingByTareaId(Integer id_tarea) {


        final String query = "SELECT tarea.id_emergencia as emergencia, tarea.id as id_tarea,nombre as nombre_tarea, cant_vol_requeridos, id_voluntario, puntaje\n" +
                "FROM tarea INNER JOIN ranking ON tarea.id = ranking.id_tarea\n" +
                "where tarea.id = :id_tarea\n"+
                "order by puntaje desc";
        final List<RankingByTarea> rankingByTarea;
        Connection conn = sql2o.open();
        try(conn){
            System.out.println(query+"<-Query");
            rankingByTarea = conn.createQuery(query)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(RankingByTarea.class);
            return rankingByTarea;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }


    @Override
    public List<RankingByTarea> getRankingByTarea(){
        final String query = "SELECT tarea.id_emergencia as emergencia, tarea.id as id_tarea,nombre as nombre_tarea, cant_vol_requeridos, id_voluntario, puntaje\n" +
                "FROM tarea INNER JOIN ranking ON tarea.id = ranking.id_tarea\n" +
                "group by puntaje, tarea.id, nombre_tarea,cant_vol_requeridos,id_voluntario\n" +
                "order by cant_vol_requeridos desc, puntaje desc";
        final List<RankingByTarea> rankingByTareaList;
        Connection conn = sql2o.open();
        try(conn){
            rankingByTareaList = conn.createQuery(query).executeAndFetch(RankingByTarea.class);
            return rankingByTareaList;
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
