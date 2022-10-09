package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class RankingByEmergencia {

    public String nombre;
    public int req_cumplidos;
    public int id_voluntario;

    public RankingByEmergencia(String nombre, int req_cumplidos, int id_voluntario) {
        this.nombre = nombre;
        this.req_cumplidos = req_cumplidos;
        this.id_voluntario = id_voluntario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getReq_cumplidos() {
        return req_cumplidos;
    }

    public int getId_voluntario() {
        return id_voluntario;
    }
}
