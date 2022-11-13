package com.grupo4TBD.Lab2.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class RankingByView {
    Integer id_voluntario;
    String nombre;
    Integer cantidad;

    public RankingByView(Integer id_voluntaro, String nombre, Integer cantidad) {
        this.id_voluntario = id_voluntario;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Integer getId_voluntaro() {
        return id_voluntario;
    }

    public void setId_voluntaro(Integer id_voluntaro) {
        this.id_voluntario = id_voluntaro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
