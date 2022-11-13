package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.Voluntario;
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
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
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
    //Se crea el voluntario
    //se necesitan el nombre y la fecha de nacimiento del voluntario
    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {

            System.out.println(voluntario.getNombre()+"nombres y desc"+voluntario.getFnacimiento());

            Integer myId = generateId()+1;
            System.out.println("myId = "+myId);
            final String query = "insert into voluntario (id,nombre) values (:myId,:nombre)";
            System.out.println("Intenta conexion...");
            Connection conn = sql2o.open();
            try (conn) {
                System.out.println("Dentro de Intenta conexion...");
                conn.createQuery(query)
                        .addParameter("myId", myId)
                        .addParameter("nombre", voluntario.getNombre())
                        .executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            } finally {
                conn.close();
            }
            System.out.println("Conexion exitosa!... Dato ingresado en la base de datos...");
            return voluntario;

    }

    //Getter de voluntarioes por el id, se requiere del id a buscar.
    @Override
    public Voluntario getVoluntarioById(Integer id) {

        System.out.println("Intento getvoluntarioById...");
        final String query = "select * from voluntario where id = :id";
        final Voluntario voluntario;
        Connection conn = sql2o.open();
        try(conn){
            voluntario = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
            return voluntario;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }

    }


    //Getter de todas las voluntarioes (sin compaginado).
    @Override
    public List<Voluntario> getAllVoluntarios(){
        final String query = "select * from voluntario";
        final List<Voluntario> voluntarioList;
        Connection conn = sql2o.open();
        try(conn){
            voluntarioList = conn.createQuery(query).executeAndFetch(Voluntario.class);
            return voluntarioList;
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
    public Voluntario updateVoluntario(Voluntario voluntario){
        if(voluntario.getNombre().length()!=0 && voluntario.getFnacimiento().toLocalDate() != null){
            final String query = "update voluntario set nombre = :nombre, fnacimiento =:fnacimiento  where id = :id";
            Connection conn = sql2o.open();
            try(conn){
                conn.createQuery(query)
                        .addParameter("id", voluntario.getId())
                        .addParameter("nombre", voluntario.getNombre())
                        .addParameter("fnacimiento", voluntario.getFnacimiento())
                        .executeUpdate();
                return voluntario;
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
            System.out.println("Else null createvoluntario...");
            return null;
        }
    }

    //Hard delete para una voluntario por id.
    @Override
    public void deleteVoluntarioById(Integer id){
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM voluntario WHERE id=:id";
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
    public void deleteVoluntarios(){
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM voluntario";
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
    public void generateViewByIdEmergencia(String inputId) {
        final String query = "create or replace view tareas_emergencia as select tarea.id_emergencia,tarea.nombre,tarea.id " +
                "as id_tarea from tarea, emergencia where tarea.id_emergencia ="+inputId+" and tarea.id_emergencia = emergencia.id";
        Connection conn = sql2o.open();

        try(conn){
            System.out.println("Intenta conexion dentro de try...");
            conn.createQuery(query).executeUpdate();
             System.out.println("Exito con exito...");
        }
        catch(Exception e){
            System.out.println("query fallida con exito!");
            System.out.println(e.getMessage());
        }
        finally {
            conn.close();
        }
    }
}
