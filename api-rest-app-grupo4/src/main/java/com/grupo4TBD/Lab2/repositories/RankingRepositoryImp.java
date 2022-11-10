package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.Ranking;
import com.grupo4TBD.Lab2.services.TareaService;
import com.grupo4TBD.Lab2.services.VoluntarioService;
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
public class RankingRepositoryImp implements RankingRepository {
    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;
    VoluntarioService voluntarioService;
    TareaService tareaService;
    @Override
    public Integer generateIdRanking(){
        Integer newId;
        String queryId = "select max(id) from ranking";
        Connection conn = sql2o.open();
        try(conn){
            System.out.println("Entro dentro de try...");
            newId=conn.createQuery(queryId)
                    .executeScalar(Integer.class);
            if(newId==null){
                return 0;
            }
            else {
                return newId;
            }

        }
        catch(Exception e){
            System.out.println("Entro en la excepcion...");
            return 0;
        }
        finally {
            conn.close();
        }
    }
    @Override
    public Ranking createRanking(Ranking ranking) {
        int id_voluntario = voluntarioService.getVoluntarioById(ranking.getId_voluntario()).getId();
        int id_tarea = tareaService.getTareaById(ranking.getId_tarea()).getId();
        if(id_voluntario > 0 && id_tarea > 0){
            Integer myId = generateIdRanking()+1;
            System.out.println("myId = "+myId);
            final String query = "insert into ranking (id,id_voluntario,id_tarea,puntaje,flg_invitado,flg_participa) values (:myId,:id_voluntario,:id_tarea,:puntaje,:flg_invitado,:flg_participa)";
            try (Connection conn = sql2o.open()) {
                conn.createQuery(query)
                        .addParameter("myId", myId)
                        .addParameter("id_voluntario", ranking.getId_voluntario())
                        .addParameter("id_tarea", ranking.getId_tarea())
                        .addParameter("puntaje", ranking.getPuntaje())
                        .addParameter("flg_invitado", ranking.getFlg_invitado())
                        .addParameter("flg_participa", ranking.getFlg_participa())
                        .executeUpdate();
                return ranking;
            }
        }
        else{
            return null;
        }
    }

    @Override
    public Ranking getRankingById(Integer id) {

        System.out.println("Intento getTarea...");
        final String query = "select * from ranking where id = :id";
        final Ranking Ranking;
        Connection conn = sql2o.open();
        try(conn){
            Ranking = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranking.class);
            return Ranking;
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
    public List<Ranking> getAllRankings() {

        final String query = "select * from ranking";
        final List<Ranking> rankingList;
        Connection conn = sql2o.open();
        try(conn){
            rankingList = conn.createQuery(query).throwOnMappingFailure(false).executeAndFetch(Ranking.class);
            return rankingList;
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
    public Ranking updateRanking(Ranking ranking) {
        int id_voluntario = voluntarioService.getVoluntarioById(ranking.getId_voluntario()).getId();
        int id_tarea = tareaService.getTareaById(ranking.getId_tarea()).getId();
        int puntaje = ranking.getPuntaje();
        int flg_invitado = ranking.getFlg_invitado();
        int flg_participa = ranking.getFlg_participa();
        if(id_voluntario > 0 && id_tarea > 0 && puntaje > 0 && flg_invitado == 0 || flg_invitado == 1 && flg_participa == 0 || flg_participa == 1){
            final String query = "update Ranking set nombre = :nombre, descrip = :descrip, finicio = :finicio, ffin = :ffin, id_estado = :id_estado where id = :id";
            Connection conn = sql2o.open();
            try(conn){
                conn.createQuery(query)
                        .addParameter("id", ranking.getId())
                        .addParameter("id_voluntaro", ranking.getId_voluntario())
                        .addParameter("id_tarea", ranking.getId_tarea())
                        .addParameter("puntaje", ranking.getPuntaje())
                        .addParameter("flg_invitado", ranking.getFlg_invitado())
                        .addParameter("flg_participa", ranking.getFlg_participa())
                        .executeUpdate();
                return ranking;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
            finally {
                conn.close();
            }
        }
        else{
            System.out.println("Else null updateRanking...");
            return null;
        }
    }

    @Override
    public void deleteRankingById(Integer id) {

        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM ranking WHERE id=:id";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            System.out.println("Eliminado con exito...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Excepcion...");
        }
        finally {
            conn.close();
        }

    }

    @Override
    public void deleteRanking() {
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM ranking";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .executeUpdate();
            System.out.println("Eliminado con exito...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Excepcion...");
        }
        finally {
            conn.close();
        }
    }
}
