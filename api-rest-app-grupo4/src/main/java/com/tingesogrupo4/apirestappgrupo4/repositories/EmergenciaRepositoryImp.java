package com.tingesogrupo4.apirestappgrupo4.repositories;
import com.tingesogrupo4.apirestappgrupo4.models.Emergencia;
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
public class EmergenciaRepositoryImp implements EmergenciaRepository {
    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer generateIdEmergencia(){
        Integer newId;
        String queryId = "select max(id) from emergencia";
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
        public Emergencia createEmergencia(Emergencia emergencia) {
            if(emergencia.getNombre().length()!=0 && emergencia.getDescrip().length()!=0){
                Integer myId = generateIdEmergencia()+1;
                System.out.println("myId = "+myId);
                final String query = "insert into emergencia (id,nombre,descrip,finicio,ffin,id_estado) values (:myId,:nombre,:descrip,:finicio,:ffin,:id_estado)";
                try (Connection conn = sql2o.open()) {
                    conn.createQuery(query)
                            .addParameter("myId", myId)
                            .addParameter("nombre", emergencia.getNombre())
                            .addParameter("descrip", emergencia.getDescrip())
                            .addParameter("finicio", emergencia.getFinicio())
                            .addParameter("ffin", emergencia.getFfin())
                            .addParameter("id_estado", emergencia.getId_institucion())
                            .executeUpdate();
                    return emergencia;
                }
            }
            else{
                return null;
            }
        }

    @Override
    public Emergencia getEmergenciaById(Integer id) {

        final String query = "select * from emergencia where id = :id";
        final Emergencia emergencia;
        Connection conn = sql2o.open();
        try(conn){
            emergencia = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
            return emergencia;
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
    public List<Emergencia> getAllEmergencia() {

        final String query = "select * from emergencia";
        final List<Emergencia> emergenciaList;
        Connection conn = sql2o.open();
        try(conn){
            emergenciaList = conn.createQuery(query)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Emergencia.class);
            return emergenciaList;
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
    public Emergencia updateEmergencia(Emergencia emergencia) {

        if(emergencia.getNombre().length()!=0 && emergencia.getDescrip().length()!=0){
            final String query = "update emergencia set nombre = :nombre, descrip = :descrip, finicio = :finicio, ffin = :ffin, id_estado = :id_estado where id = :id";
            Connection conn = sql2o.open();
            try(conn){
                conn.createQuery(query)
                        .addParameter("id", emergencia.getId())
                        .addParameter("nombre", emergencia.getNombre())
                        .addParameter("descrip", emergencia.getDescrip())
                        .addParameter("finicio", emergencia.getFinicio())
                        .addParameter("ffin", emergencia.getFfin())
                        .addParameter("id_estado", emergencia.getId_institucion())
                        .executeUpdate();
                return emergencia;
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
    public void deleteEmergenciaById(Integer id) {

        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM emergencia WHERE id=:id";
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
    public void deleteEmergencia() {
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM emergencia";
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
