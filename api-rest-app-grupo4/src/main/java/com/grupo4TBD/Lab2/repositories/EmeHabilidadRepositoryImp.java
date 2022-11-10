package com.grupo4TBD.Lab2.repositories;


import com.grupo4TBD.Lab2.models.EmeHabilidad;
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
public class EmeHabilidadRepositoryImp implements EmeHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer generateId(){
        Integer newId;
        String queryId = "select max(id) from eme_habilidad";
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
    public EmeHabilidad createEmeHabilidad(EmeHabilidad emeHabilidad) {
        Integer myId = generateId()+1;
        System.out.println("myId = "+myId);
        final String query = "insert into eme_habilidad (id,id_emergencia,id_habilidad) values (:myId,:id_emergencia,:id_habilidad)";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("myId", myId)
                    .addParameter("id_emergencia", emeHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emeHabilidad.getId_habilidad())
                    .executeUpdate();
            return emeHabilidad;
        }
    }
    @Override
    public EmeHabilidad getEmeHabilidadById(Integer id) {

        System.out.println("Intento getTarea...");
        final String query = "select * from eme_habilidad where id = :id";
        final EmeHabilidad emeHabilidad;
        Connection conn = sql2o.open();
        try(conn){
            emeHabilidad = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmeHabilidad.class);
            return emeHabilidad;
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
    public List<EmeHabilidad> getAllEmeHabilidad() {

        final String query = "select * from eme_habilidad";
        final List<EmeHabilidad> emeHabilidadList;
        Connection conn = sql2o.open();
        try(conn){
            emeHabilidadList = conn.createQuery(query).throwOnMappingFailure(false).executeAndFetch(EmeHabilidad.class);
            return emeHabilidadList;
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
    public EmeHabilidad updateEmeHabilidad(EmeHabilidad emeHabilidad) {
        final String query = "update eme_habilidad set id_emergencia=:id_emergencia, id_habilidad=:id_habilidad where id = :id";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id", emeHabilidad.getId())
                    .addParameter("id_emergencia", emeHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emeHabilidad.getId_habilidad())
                    .executeUpdate();
            return emeHabilidad;
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
    public void deleteEmeHabilidadById(Integer id) {
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM eme_habilidad WHERE id=:id";
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
    public void deleteEmeHabilidad() {
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM eme_habilidad";
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

