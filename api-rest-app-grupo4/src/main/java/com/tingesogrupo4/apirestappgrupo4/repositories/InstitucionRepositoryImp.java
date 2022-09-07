package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Component
@Configuration
@Repository
public class InstitucionRepositoryImp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;


    @Override
    public Institucion createInstitucion(Institucion institucion) {
        final String query = "insert into institucion (id, nombre, descrip) values (:id, :nombre, :descrip)";
        System.out.println("Intenta conexion...");
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id", institucion.getId())
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

}
