package com.grupo4TBD.Lab2.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@EntityScan
public class Emergencia {
    //Se establece el modelo para Emergencia
    //Se genera un constructor y sus repectivos selectores.
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
    //Se obtiene el id de la emergencia
    public int getId() {
        return id;
    }
    //Se obtiene el nombre de la emergencia
    public String getNombre() {
        return nombre;
    }
    //Se obtiene la descripcion de la emergencia
    public String getDescrip() {
        return descrip;
    }
    //Se obtiene la fecha de inicio de la emergencia
    public Date getFinicio() {
        return finicio;
    }
    //Se obtiene la fecha de fin de la emergencia
    public Date getFfin() {
        return ffin;
    }
    //Se obtiene el id de la institucion
    public Integer getId_institucion() {
        return id_institucion;
    }


}
