package com.grupo4TBD.Lab2.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Ranking {
    //Se establece el modelo para ranking
    //Se genera un constructor y sus repectivos selectores.
    public int id;
    public int id_voluntario;
    public int id_tarea;
    public int puntaje;
    public int flg_invitado;
    public int flg_participa;

    public Ranking(int id, int id_voluntario, int id_tarea, int puntaje, int flg_invitado, int flg_participa) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_tarea = id_tarea;
        this.puntaje = puntaje;
        this.flg_invitado = flg_invitado;
        this.flg_participa = flg_participa;
    }
    //Se obtiene el id del ranking
    public int getId() {
        return id;
    }
    //Se obtiene el id del voluntario
    public int getId_voluntario() {
        return id_voluntario;
    }
    //Se obtiene el id de la tarea
    public int getId_tarea() {
        return id_tarea;
    }
    //Se obtiene el puntaje del voluntario
    public int getPuntaje() {
        return puntaje;
    }
    //Se obtiene el flag de invitado
    public int getFlg_invitado() {
        return flg_invitado;
    }
    //Se obtiene el flag de participa
    public int getFlg_participa() {
        return flg_participa;
    }


}
