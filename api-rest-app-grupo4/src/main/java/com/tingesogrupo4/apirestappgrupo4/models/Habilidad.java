package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Habilidad {
    public int id;
    public String descrip;

    public Habilidad(int id, String descrip) {
        this.id = id;
        this.descrip = descrip;
    }
    public int getId() {
        return id;
    }
    public String getDescrip() {
        return descrip;
    }

}
