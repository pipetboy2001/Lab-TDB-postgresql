package com.grupo4TBD.Lab2.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class EmeHabilidad {
    public int id;
    public int id_emergencia;
    public int id_habilidad;

    public EmeHabilidad(int id, int id_emergencia, int id_habilidad) {
        //Se establece el modelo para la tabla EmeHabilidad
        //Se genera un constructor y sus repectivos selectores.
        this.id = id;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }
    //Se obtiene el id de la tabla EmeHabilidad
    public int getId() {
        return id;
    }
    //Se obtiene el id de la emergencia
    public int getId_emergencia() {
        return id_emergencia;
    }
    //Se obtiene el id de la habilidad
    public int getId_habilidad() {
        return id_habilidad;
    }

}
