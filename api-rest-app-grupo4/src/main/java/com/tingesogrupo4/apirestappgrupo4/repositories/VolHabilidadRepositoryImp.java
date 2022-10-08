package com.tingesogrupo4.apirestappgrupo4.repositories;


import com.tingesogrupo4.apirestappgrupo4.models.VolHabilidad;
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
public class VolHabilidadRepositoryImp implements VolHabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer generateId(){
        Integer newId;
        String queryId = "select max(id) from voluntario";
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
    public VolHabilidad createVolHabilidad(VolHabilidad volHabilidad) {
            Integer myId = generateId()+1;
            System.out.println("myId = "+myId);
            final String query = "insert into vol_habilidad (id,id_voluntario, id_habilidad) values (:myId,:id_voluntario,:id_habilidad)";
            System.out.println("Intenta conexion...");
            Connection conn = sql2o.open();
            try (conn) {
                System.out.println("Dentro de Intenta conexion...");
                conn.createQuery(query)
                        .addParameter("myId", myId)
                        .addParameter("id_voluntario", volHabilidad.getId_voluntario())
                        .addParameter("id_habilidad", volHabilidad.getId_habilidad())
                        .executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            } finally {
                conn.close();
            }
            System.out.println("Conexion exitosa!... Dato ingresado en la base de datos...");
            return volHabilidad;
    }

    @Override
    public VolHabilidad getVolHabilidadById(Integer id) {

        System.out.println("Intento getvoluntarioById...");
        final String query = "select * from vol_habilidad where id = :id";
        final VolHabilidad volHabilidad;
        Connection conn = sql2o.open();
        try(conn){
            volHabilidad = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VolHabilidad.class);
            return volHabilidad;
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
    public List<VolHabilidad> getAllVolHabilidad(){
        final String query = "select * from vol_habilidad";
        final List<VolHabilidad> VolHabilidadList;
        Connection conn = sql2o.open();
        try(conn){
            VolHabilidadList = conn.createQuery(query).executeAndFetch(VolHabilidad.class);
            return VolHabilidadList;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }


    //Se actualiza la voluntario, se requiere de un objeto voluntario.
    @Override
    public VolHabilidad updateVolHabilidad(VolHabilidad volHabilidad){

        final String query = "update vol_habilidad set id_voluntario = :id_voluntario, id_habilidad =:id_habilidad  where id = :id";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id", volHabilidad.getId())
                    .addParameter("id_voluntario", volHabilidad.getId_voluntario())
                    .addParameter("id_habilidad", volHabilidad.getId_habilidad())
                    .executeUpdate();
            return volHabilidad;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }

    }

    //Hard delete para una voluntario por id.
    @Override
    public void deleteVolHabilidadById(Integer id){
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM vol_habilidad WHERE id=:id";
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
    //Hard delete para todas las voluntarioes.
    @Override
    public void deleteAllVolHabilidades(){
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM vol_habilidad";
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
