package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan

public class Institucion {

    public Integer id;
    public String nombre;
    public String descrip;


    public Institucion (Integer id, String nombre, String descrip){
        this.id= id;
        this.nombre = nombre;
        this.descrip = descrip;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return nombre;
    }
    public String getDescription(){
        return descrip;
    }

}
