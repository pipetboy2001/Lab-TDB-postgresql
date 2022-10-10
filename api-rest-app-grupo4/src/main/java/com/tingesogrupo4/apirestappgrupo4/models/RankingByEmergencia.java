package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class RankingByEmergencia {
    //Se establece el modelo para RankingByEmergencia
    //Se genera un constructor y sus repectivos selectores.
    public String nombre;
    public int req_cumplidos;
    public int id_voluntario;

    public RankingByEmergencia(String nombre, int req_cumplidos, int id_voluntario) {
        this.nombre = nombre;
        this.req_cumplidos = req_cumplidos;
        this.id_voluntario = id_voluntario;
    }
    //Se obtiene el nombre del voluntario
    public String getNombre() {
        return nombre;
    }
    //Se obtiene la cantidad de requerimientos cumplidos
    public int getReq_cumplidos() {
        return req_cumplidos;
    }
    //Se obtiene el id del voluntario
    public int getId_voluntario() {
        return id_voluntario;
    }
}
