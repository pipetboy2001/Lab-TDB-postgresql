package com.grupo4TBD.Lab2.repositories;
import com.grupo4TBD.Lab2.models.Tarea;
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
public class TareaRepositoryImp implements TareaRepository {
    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;


    @Override
    public Integer generateIdTarea(){
        Integer newId;
        String queryId = "select max(id) from tarea";
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
    public Tarea createTarea(Tarea tarea) {
        if(tarea.getName().length()!=0 && tarea.getDescription().length()!=0){
            Integer myId = generateIdTarea()+1;
            System.out.println("Tarea:"+tarea);
            System.out.println("Longitud : "+tarea.getLongitud()+" Latitud : "+tarea.getLatitud());
            System.out.println("myId = "+myId);
            final String query = "insert into tarea (id,nombre,descrip,cant_vol_requeridos,cant_vol_inscritos,id_emergencia,finicio,ffin,id_estado,longitud,latitud,geom)" +
                    " values (:myId,:nombre,:descrip,:cant_vol_req,:cant_vol_inscritos,:id_emergencia,:finicio,:ffin,:id_estado,:longitud,:latitud,ST_MakePoint(:longitud,:latitud))";
            try (Connection conn = sql2o.open()) {
                System.out.println("Entro dentro de try 2...");
                conn.createQuery(query)
                        .addParameter("myId", myId)
                        .addParameter("nombre", tarea.getName())
                        .addParameter("descrip", tarea.getDescription())
                        .addParameter("cant_vol_req", tarea.getCantidadVolRequeridos())
                        .addParameter("cant_vol_inscritos", tarea.getCantidadVolInscritos())
                        .addParameter("id_emergencia", tarea.getIdEmergencia())
                        .addParameter("finicio", tarea.getFechaInicio())
                        .addParameter("ffin", tarea.getFechaFin())
                        .addParameter("id_estado", tarea.getIdEstadoTarea())
                        .addParameter("latitud", tarea.getLatitud())
                        .addParameter("longitud", tarea.getLongitud())
                        //.addParameter("geom", tarea.getGeom())
                        .executeUpdate();
                System.out.println("Entro dentro de try 3...");
                return tarea;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else{
            return null;
        }
    }




    @Override
    public Tarea getTareaById(Integer id) {

        System.out.println("Intento getTarea...");
        final String query = "select * from tarea where id = :id";
        final Tarea tarea;
        Connection conn = sql2o.open();
        try(conn){
            tarea = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea.class);
            return tarea;
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
    public List<Tarea> getAllTareas() {

        final String query = "select * from tarea";
        final List<Tarea> tareaList;
        Connection conn = sql2o.open();
        try(conn){
            tareaList = conn.createQuery(query).throwOnMappingFailure(false).executeAndFetch(Tarea.class);
            return tareaList;
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
    public Tarea updateTarea(Tarea tarea) {

        if(tarea.getName().length()!=0 && tarea.getDescription().length()!=0){
            final String query = "update tarea set nombre = :nombre, descrip = :descrip, cant_vol_requeridos = :cant_vol_req, cant_vol_inscritos = :cant_vol_inscritos, id_emergencia = :id_emergencia, finicio = :finicio, ffin = :ffin, id_estado = :id_estado , longitud = :longitud, latitud = :latitud, geom := ST_MakePoint(:longitud,:latitud)  where id = :id";
            Connection conn = sql2o.open();
            try(conn){
                conn.createQuery(query)
                        .addParameter("id", tarea.getId())
                        .addParameter("nombre", tarea.getName())
                        .addParameter("descrip", tarea.getDescription())
                        .addParameter("cant_vol_req", tarea.getCantidadVolRequeridos())
                        .addParameter("cant_vol_inscritos", tarea.getCantidadVolInscritos())
                        .addParameter("id_emergencia", tarea.getIdEmergencia())
                        .addParameter("finicio", tarea.getFechaInicio())
                        .addParameter("ffin", tarea.getFechaFin())
                        .addParameter("id_estado", tarea.getIdEstadoTarea())
                        .addParameter("latitud", tarea.getLatitud())
                        .addParameter("longitud", tarea.getLongitud())
                        .addParameter("geom", tarea.getGeom())
                        .executeUpdate();
                return tarea;
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
            System.out.println("Else null updateTarea...");
            return null;
        }
    }

    @Override
    public void deleteTareaById(Integer id) {

        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM tarea WHERE id=:id";
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
    public void deleteTareas() {
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM tarea";
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

    @Override
    public List<Tarea> getTareasByIdRegion(Integer idRegion) {
        final String query = "SELECT tarea.id, tarea.nombre, tarea.descrip, tarea.cant_vol_requeridos, " +
                "tarea.cant_vol_inscritos, tarea.id_emergencia, tarea.finicio, tarea.ffin, ST_AsText(tarea.geom) AS geom FROM  " +
                "tarea JOIN region ON ST_Intersects(region.geom,tarea.geom) WHERE region.gid = :idRegion";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .addParameter("idRegion", idRegion)
                    .executeAndFetch(Tarea.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }





    }

}
