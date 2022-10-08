package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.Habilidad;
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
public class HabilidadRepositoryImp implements HabilidadRepository {

    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer generateId(){
        Integer newId;
        String queryId = "select max(id) from habilidad";
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


    //Se crea la habilidad
    @Override
    public Habilidad createHabilidad(Habilidad habilidad) {
        if(habilidad.getDescrip().length()!=0){

            Integer myId = generateId()+1;
            System.out.println("myId = "+myId);
            final String query = "insert into habilidad (id,descrip) values (:myId,:descrip)";
            System.out.println("Intenta conexion...");
            Connection conn = sql2o.open();
            try (conn) {
                System.out.println("Dentro de Intenta conexion...");
                conn.createQuery(query)
                        .addParameter("myId", myId)
                        .addParameter("descrip", habilidad.getDescrip())
                        .executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            } finally {
                conn.close();
            }
            System.out.println("Conexion exitosa!... Dato ingresado en la base de datos...");
            return habilidad;
        }
        else{
            System.out.println("Else null createInstitucion...");
            return null;
        }
    }


    //Getter de instituciones por el id, se requiere del id a buscar.
    @Override
    public Habilidad getHabilidadById(Integer id) {

        final String query = "select * from habilidad where id = :id";
        final Habilidad habilidad;
        Connection conn = sql2o.open();
        try(conn){
            habilidad = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
            return habilidad;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }

    }


    //Getter de todas las habilidades (sin compaginado).
    @Override
    public List<Habilidad> getAllHabilidad(){
        final String query = "select * from habilidad";
        final List<Habilidad> habilidadList;
        Connection conn = sql2o.open();
        try(conn){
            habilidadList = conn.createQuery(query)
                    .executeAndFetch(Habilidad.class);
            return habilidadList;
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
    public Habilidad updateHabilidad(Habilidad habilidad) {
        if(habilidad.getDescrip().length()!=0){
            final String query = "update habilidad set descrip = :descrip where id = :id";
            Connection conn = sql2o.open();
            try (conn) {
                conn.createQuery(query)
                        .addParameter("descrip", habilidad.getDescrip())
                        .addParameter("id", habilidad.getId())
                        .executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            } finally {
                conn.close();
            }
            return habilidad;
        }
        else{
            System.out.println("Else null updateInstitucion...");
            return null;
        }
    }
    @Override
    public void deleteHabilidadById(Integer id) {
        final String query = "delete from habilidad where id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
    }
    //Hard delete para todas las instituciones.
    @Override
    public void deleteHabilidades(){
        final String query = "DELETE FROM habilidad";
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
