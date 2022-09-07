package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan

public class Institucion {

    public Integer id;
    public String name;
    public String description;


    public Institucion (Integer id, String name, String description){
        this.id= id;
        this.name = name;
        this.description = description;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

}
