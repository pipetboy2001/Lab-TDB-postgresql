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
    public Double longitud;
    public Double latitud;
    public String geom;

    public Emergencia(int id, String nombre, String descrip, Date finicio, Date ffin, Integer id_institucion, Double longitud, Double latitud, String geom) {
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.finicio = finicio;
        this.ffin = ffin;
        this.id_institucion = id_institucion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.geom = geom;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public void setId_institucion(Integer id_institucion) {
        this.id_institucion = id_institucion;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }

    public Double getLongitud() {
        return longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public String getGeom() {
        return geom;
    }

    //Se obtiene el id de la institucion
    public Integer getId_institucion() {
        return id_institucion;
    }


}
