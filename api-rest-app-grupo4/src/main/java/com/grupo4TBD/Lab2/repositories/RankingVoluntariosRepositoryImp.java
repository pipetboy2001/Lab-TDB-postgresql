package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.RankingVoluntarios;
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
public class RankingVoluntariosRepositoryImp implements RankingVoluntariosRepository{

    // TABLE_NAME ( ranking_voluntarios )
    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer generateIdRankingVoluntarios(){
        Integer newId;
        String queryId = "select max(id) from ranking_voluntarios";
        Connection connection = sql2o.open();
        try(connection){
            System.out.println("Entro dentro de try...");
            newId=connection.createQuery(queryId).executeScalar(int.class);
            if(newId==null){
                return 0;
            }else{
                return newId;
            }
        }
        catch (Exception e){
            System.out.println("Entro a Exception...");
            return 0;
        }
        finally {
            connection.close();
        }
    }

    @Override
    public RankingVoluntarios createRankingVoluntario(RankingVoluntarios RKV){
        if(RKV.getId() > 0){
            final String query = "insert into ranking_voluntarios (id,id_emergencia,tarea,cant_vol_req,id_vol,puntaje) values (:id,:id_emergencia,:tarea,:cant_vol_req,:id_vol,:puntaje)";
            Integer myId = generateIdRankingVoluntarios()+1;
            try (Connection connection = sql2o.open()) {
                connection.createQuery(query)
                        .addParameter("id", myId)
                        .addParameter("id_emergencia", RKV.getId_emergencia())
                        .addParameter("tarea", RKV.getTarea())
                        .addParameter("cant_vol_req", RKV.getCant_vol_req())
                        .addParameter("id_vol", RKV.getId_vol())
                        .addParameter("puntaje", RKV.getPuntaje())
                        .executeUpdate();
                return RKV;
            }
        }
        else{
            return null;
        }
    }


    @Override
    public RankingVoluntarios getRankingVoluntario(Integer id){
        final String query = "select * from ranking_voluntarios where id=:id";
        final RankingVoluntarios RKV;
        Connection connection = sql2o.open();
        try(connection){
            RKV = connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(RankingVoluntarios.class);
            return RKV;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            connection.close();
        }
    }

    @Override
    public List<RankingVoluntarios> getAllRankingVoluntario(){
        final String query = "select * from ranking_voluntarios";
        final List<RankingVoluntarios> RKVList;
        Connection connection = sql2o.open();
        try(connection){
            RKVList = connection.createQuery(query)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(RankingVoluntarios.class);
            return RKVList;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            connection.close();
        }
    }

    @Override
    public RankingVoluntarios updateRankingVoluntario(RankingVoluntarios RKV){
        if(RKV.getId_emergencia() > 0){
            final String query = "update ranking_voluntarios set id_emergencia=:id_emergencia,tarea=:tarea,cant_vol_req=:cant_vol_req,id_vol=:id_vol,puntaje=:puntaje where id=:id";
            Connection connection = sql2o.open();
            try(connection){
                connection.createQuery(query)
                        .addParameter("id",RKV.getId())
                        .addParameter("id_emergencia",RKV.getId_emergencia())
                        .addParameter("tarea",RKV.getTarea())
                        .addParameter("cant_vol_req",RKV.getCant_vol_req())
                        .addParameter("id_vol",RKV.getId_vol())
                        .addParameter("puntaje",RKV.getPuntaje())
                        .executeUpdate();
                return RKV;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }else{
            System.out.println("Else null updateRankingVoluntario");
            return null;
        }
    }

    @Override
    public void deleteRankingVoluntarioById(Integer id){
        System.out.println("Eliminando RKV by Id...");
        final String query = "delete from ranking_voluntarios where id=:id";
        Connection connection = sql2o.open();
        try(connection){
            connection.createQuery(query)
                    .addParameter("id",id).executeUpdate();
            System.out.println("Eliminado con éxito...");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            connection.close();
        }
    }

    @Override
    public void deleteRankingVoluntario(){
        System.out.println("Eliminando RKV completo...");
        final String query = "delete from ranking_voluntarios";
        Connection connection = sql2o.open();
        try(connection){
            connection.createQuery(query).executeUpdate();
            System.out.println("Elementos eliminados con éxito");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            connection.close();
        }
    }

    /***
    @Override
    public List<RankingVoluntarios> getAllRankingVoluntarioOrderByPuntaje(){
        final String query = "select * from ranking_voluntarios as rv order by rv.puntaje desc ";
        final List<RankingVoluntarios> RKVList;
        Connection connection = sql2o.open();
        try(connection){
            RKVList = connection.createQuery(query)
                    .addParameter("puntaje",RKVList.get().getPuntaje())
                    .throwOnMappingFailure(false)
                    .executeAndFetch(RankingVoluntarios.class);
            return RKVList;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            connection.close();
        }
    }
    */

}
