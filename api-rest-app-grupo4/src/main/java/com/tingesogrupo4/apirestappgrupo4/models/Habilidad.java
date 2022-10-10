package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Habilidad {
    ////Se establece el modelo para Habilidad
    //Se genera un constructor y sus repectivos selectores.
    public int id;
    public String descrip;

    public Habilidad(int id, String descrip) {
        this.id = id;
        this.descrip = descrip;
    }
    //Se obtiene el id de la habilidad
    public int getId() {
        return id;
    }
    //Se obtiene la descripcion de la habilidad
    public String getDescrip() {
        return descrip;
    }

}
