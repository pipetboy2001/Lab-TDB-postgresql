package com.grupo4TBD.Lab2.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class VolHabilidad {
    //Se establece el modelo para la tabla VolHabilidad 
    //Se genera un constructor y sus repectivos selectores.
    public int id;
    public int id_voluntario;
    public int id_habilidad;

    public VolHabilidad(int id, int id_voluntario, int id_habilidad) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }
    //Se obtiene el id de la tabla VolHabilidad
    public int getId() {
        return id;
    }
    //Se obtiene el id del voluntario
    public int getId_voluntario() {
        return id_voluntario;
    }
    //Se obtiene el id de la habilidad
    public int getId_habilidad() {
        return id_habilidad;
    }
}
