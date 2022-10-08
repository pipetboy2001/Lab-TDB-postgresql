package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;

@EntityScan
public class Voluntario {
    public Integer id;
    public String nombre;
    public Date fnacimiento;

    public Voluntario(String nombre, Date fnacimiento) {
        this.nombre = nombre;
        this.fnacimiento = fnacimiento;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }
}
