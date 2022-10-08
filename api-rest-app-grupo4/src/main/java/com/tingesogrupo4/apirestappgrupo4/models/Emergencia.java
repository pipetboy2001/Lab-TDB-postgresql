package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@EntityScan
public class Emergencia {
    public int id;
    public String nombre;
    public String descrip;
    public Date finicio;
    public Date ffin;
    public Integer id_institucion;

    public Emergencia(int id, String nombre, String descrip, Date finicio, Date ffin, Integer id_institucion) {
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.finicio = finicio;
        this.ffin = ffin;
        this.id_institucion = id_institucion;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescrip() {
        return descrip;
    }
    public Date getFinicio() {
        return finicio;
    }
    public Date getFfin() {
        return ffin;
    }
    public Integer getId_institucion() {
        return id_institucion;
    }


}
