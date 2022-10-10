package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;

@EntityScan
public class Voluntario {
    //Se establece el modelo para institucion
    //Se genera un constructor y sus repectivos selectores.
    public Integer id;
    public String nombre;
    public Date fnacimiento;

    public Voluntario(String nombre, Date fnacimiento) {
        this.nombre = nombre;
        this.fnacimiento = fnacimiento;
    }
    //Se obtiene el id del voluntario   
    public Integer getId() {
        return id;
    }
    //Se obtiene el nombre del voluntario
    public String getNombre() {
        return nombre;
    }
    //Se obtiene la fecha de nacimiento del voluntario
    public Date getFnacimiento() {
        return fnacimiento;
    }
    //Se permite colocar un ud del voluntario
    public void setId(Integer id) {
        this.id = id;
    }
    //Se permite colocar un nombre del voluntario
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Se permite colocar una fecha de nacimiento del voluntario 
    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }
}
