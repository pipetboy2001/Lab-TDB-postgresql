package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.TareaHabilidad;
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
public class TareaHabilidadRepositoryImp implements TareaHabilidadRepository {
    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer generateId() {
        Integer newId;
        String queryId = "select max(id) from tarea_habilidad";
        Connection conn = sql2o.open();
        try (conn) {
            System.out.println("Entro dentro de try...");
            newId = conn.createQuery(queryId)
                    .executeScalar(Integer.class);
            if (newId == null) {
                return 0;
            } else {
                return newId;
            }

        } catch (Exception e) {
            System.out.println("Entro en la excepcion...");
            return 0;
        } finally {
            conn.close();
        }
    }


    @Override
    public TareaHabilidad createTareaHabilidad(TareaHabilidad tareaHabilidad) {
        Integer myId = generateId() + 1;
        System.out.println("myId = " + myId);
        final String query = "insert into tarea_habilidad (id,id_emehab, id_tarea) values (:myId,:id_emehab,:id_tarea)";
        System.out.println("Intenta conexion...");
        Connection conn = sql2o.open();
        try (conn) {
            System.out.println("Dentro de Intenta conexion...");
            conn.createQuery(query)
                    .addParameter("myId", myId)
                    .addParameter("id_emehab", tareaHabilidad.getId_emehab())
                    .addParameter("id_tarea", tareaHabilidad.getId_tarea())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conn.close();
        }
        System.out.println("Conexion exitosa!... Dato ingresado en la base de datos...");
        return tareaHabilidad;
    }

    //Getter de tareaHabilidad por el id, se requiere del id a buscar.
    @Override
    public TareaHabilidad getTareaHabilidadById(Integer id) {
        System.out.println("Intento getInstitucionById...");
        final String query = "select * from tarea_habilidad where id = :id";
        final TareaHabilidad tareaHabilidad;
        Connection conn = sql2o.open();
        try (conn) {
            tareaHabilidad = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaHabilidad.class);
            return tareaHabilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conn.close();
        }
    }

    //Getter de todas las tareaHabilidad (sin compaginado).
    @Override
    public List<TareaHabilidad> getAllTareaHabilidad() {
        final String query = "select * from tarea_habilidad";
        final List<TareaHabilidad> tareaHabilidadList;
        Connection conn = sql2o.open();
        try (conn) {
            tareaHabilidadList = conn.createQuery(query)
                    .executeAndFetch(TareaHabilidad.class);
            return tareaHabilidadList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conn.close();
        }
    }

    //Se actualiza la institucion, se requiere de un objeto institucion.
    @Override
    public TareaHabilidad updateTareaHabilidad(TareaHabilidad tareaHabilidad) {
        final String query = "update tarea_habilidad set id_emehab = :id_emehab, id_tarea =:id_tarea  where id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(query)
                    .addParameter("id", tareaHabilidad.getId())
                    .addParameter("id_emehab", tareaHabilidad.getId_emehab())
                    .addParameter("id_tarea", tareaHabilidad.getId_tarea())
                    .executeUpdate();
            return tareaHabilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conn.close();
        }
    }


    //Hard delete para una institucion por id.
    @Override
    public void deleteTareaHabilidadById(Integer id) {
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM tarea_habilidad WHERE id=:id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            System.out.println("Eliminado con exito...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Excepcion...");
        } finally {
            conn.close();
        }
    }

    //Hard delete para todas las instituciones.
    @Override
    public void deleteTareaHabilidad() {
        System.out.println("Intento eliminar...");
        final String query = "DELETE FROM tarea_habilidad";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(query)
                    .executeUpdate();
            System.out.println("Eliminado con exito...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Excepcion...");
        } finally {
            conn.close();
        }
    }
}




