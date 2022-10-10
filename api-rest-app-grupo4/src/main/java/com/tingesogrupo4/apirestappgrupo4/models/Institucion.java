package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan

public class Institucion {

    //Se establece el modelo para institucion
    //Se genera un constructor y sus repectivos selectores.
    public Integer id;
    public String nombre;
    public String descrip;


    public Institucion (Integer id, String nombre, String descrip){
        this.id= id;
        this.nombre = nombre;
        this.descrip = descrip;
    }
    //Se obtiene el id de la institucion
    public Integer getId(){
        return id;
    }
    //Se obtiene el nombre de la institucion
    public String getName(){
        return nombre;
    }
    //Se obtiene la descripcion de la institucion
    public String getDescription(){
        return descrip;
    }

}
