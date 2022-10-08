package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class TareaHabilidad {
    public int id;
    public int id_tarea;
    public int id_emehab;

    public TareaHabilidad(int id, int id_tarea, int id_emehab) {
        this.id = id;
        this.id_tarea = id_tarea;
        this.id_emehab = id_emehab;
    }
    public int getId() {
        return id;
    }
    public int getId_tarea() {
        return id_tarea;
    }
    public int getId_emehab() {
        return id_emehab;
    }

}
