package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.Emergencia;
import com.tingesogrupo4.apirestappgrupo4.models.EstadoTarea;
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
public class EstadoTareaRepositoryImp implements EstadoTareaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer generateId(){
        Integer newId;
        String queryId = "select max(id) from estado_tarea";
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
    public EstadoTarea createEstadoTarea(EstadoTarea estadoTarea) {
        if(estadoTarea.getDescription().length()!=0){
            Integer myId = generateId()+1;
            System.out.println("myId = "+myId);
            final String query = "insert into estado_tarea (id,descrip) values (:myId,:descrip)";
            try (Connection conn = sql2o.open()) {
                conn.createQuery(query)
                        .addParameter("myId", myId)
                        .addParameter("descrip", estadoTarea.getDescription())
                        .executeUpdate();
                return estadoTarea;
            }
        }
        else{
            return null;
        }
    }


    @Override
    public EstadoTarea getEstadoTareaById(Integer id) {

        final String query = "select * from estado_tarea where id = :id";
        final EstadoTarea estadoTarea;
        Connection conn = sql2o.open();
        try(conn){
            estadoTarea = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EstadoTarea.class);
            return estadoTarea;
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
    public List<EstadoTarea> getAllEstadoTarea() {

        final String query = "select * from estado_tarea";
        final List<EstadoTarea> estadoTareaList;
        Connection conn = sql2o.open();
        try(conn){
            estadoTareaList = conn.createQuery(query).throwOnMappingFailure(false).executeAndFetch(EstadoTarea.class);
            return estadoTareaList;
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
    public EstadoTarea updateEstadoTarea(EstadoTarea estadoTarea) {

        if(estadoTarea.getDescription().length()!=0){
            final String query = "update estado_tarea set descrip = :descrip where id = :id";
            Connection conn = sql2o.open();
            try(conn){
                conn.createQuery(query)
                        .addParameter("id", estadoTarea.getId())
                        .addParameter("descrip", estadoTarea.getDescription())
                        .executeUpdate();
                return estadoTarea;
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
            System.out.println("Else null updateEmergencia...");
            return null;
        }
    }


    @Override
    public void deleteEstadoTareaById(Integer id) {

        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM estado_tarea WHERE id=:id";
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
    public void deleteEstadoTarea() {
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM estado_tarea";
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
