package com.tingesogrupo4.apirestappgrupo4.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class VolHabilidad {
    public int id;
    public int id_voluntario;
    public int id_habilidad;

    public VolHabilidad(int id, int id_voluntario, int id_habilidad) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }
    public int getId() {
        return id;
    }
    public int getId_voluntario() {
        return id_voluntario;
    }
    public int getId_habilidad() {
        return id_habilidad;
    }
}
