package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class EmeHabilidad {
    public int id;
    public int id_emergencia;
    public int id_habilidad;

    public EmeHabilidad(int id, int id_emergencia, int id_habilidad) {
        this.id = id;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }
    public int getId() {
        return id;
    }
    public int getId_emergencia() {
        return id_emergencia;
    }
    public int getId_habilidad() {
        return id_habilidad;
    }

}
