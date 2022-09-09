package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.Institucion;
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
public class InstitucionRepositoryImp implements InstitucionRepository {

    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;

    //Se crea la institucion
    //se necesitan el nombre y la descripcion de la institucion
    //El id no ya que la generacion es autoincremental.
    @Override
    public Institucion createInstitucion(Institucion institucion) {

        final String query = "insert into institucion ( nombre, descrip) values (:nombre,:descrip)";
        System.out.println("Intenta conexion...");
        Connection conn = sql2o.open();
        try(conn){
            System.out.println("Dentro de Intenta conexion...");
            conn.createQuery(query)
                    .addParameter("nombre", institucion.getName())
                    .addParameter("descrip", institucion.getDescription())
                    .executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
        System.out.println("Conexion exitosa!... Dato ingresado en la base de datos...");
        return institucion;
    }

    //Getter de instituciones por el id, se requiere del id a buscar.
    @Override
    public Institucion getInstitucionById(Integer id) {
        System.out.println("Intento getInstitucionById...");
        final String query = "select * from institucion where id = :id";
        final Institucion institucion;
        Connection conn = sql2o.open();
        try(conn){
            institucion = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Institucion.class);
            return institucion;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }


    //Getter de todas las instituciones (sin compaginado).
    @Override
    public List<Institucion> getAllInstituciones(){
        final String query = "select * from institucion";
        final List<Institucion> institucionList;
        Connection conn = sql2o.open();
        try(conn){
            institucionList = conn.createQuery(query).executeAndFetch(Institucion.class);
            return institucionList;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

    //Se actualiza la institucion, se requiere de un objeto institucion.
    @Override
    public Institucion updateInstitucion(Institucion institucion){
        final String query = "update institucion set nombre = :nombre, descrip =:descrip  where id = :id";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id", institucion.getId())
                    .addParameter("nombre", institucion.getName())
                    .addParameter("descrip", institucion.getDescription())
                    .executeUpdate();
            return institucion;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }

    //Hard delete para una institucion por id.
    @Override
    public void deleteInstitucionById(Integer id){
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM institucion WHERE id=:id";
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
    //Hard delete para todas las instituciones.
    @Override
    public void deleteInstitucion(){
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM institucion";
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
