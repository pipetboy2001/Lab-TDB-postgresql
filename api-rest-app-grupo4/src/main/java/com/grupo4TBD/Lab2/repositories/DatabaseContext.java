package com.grupo4TBD.Lab2.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.sql2o.Sql2o;


@Component
@Configuration
public class DatabaseContext {
    //Componente de configuracion para la conexion con la base de datos.
    //Se establecen las credenciales para ingresar a esta.
    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
    private String dbPass;

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dbUrl, dbUser, dbPass);
    }
}
