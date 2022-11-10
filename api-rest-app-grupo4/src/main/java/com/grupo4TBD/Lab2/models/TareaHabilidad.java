package com.grupo4TBD.Lab2.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class TareaHabilidad {
    //Se establece el modelo para TareaHabilidad
    //Se genera un constructor y sus repectivos selectores.
    public int id;
    public int id_tarea;
    public int id_emehab;

    public TareaHabilidad(int id, int id_tarea, int id_emehab) {
        this.id = id;
        this.id_tarea = id_tarea;
        this.id_emehab = id_emehab;
    }
    //Se obtiene el id de la tabla TareaHabilidad   
    public int getId() {
        return id;
    }
    //Se obtiene el id de la tarea
    public int getId_tarea() {
        return id_tarea;
    }
    //Se obtiene el id de la tabla EmeHabilidad 
    public int getId_emehab() {
        return id_emehab;
    }

}
