package com.tingesogrupo4.apirestappgrupo4.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Ranking {

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

    public int getId() {
        return id;
    }
    public int getId_voluntario() {
        return id_voluntario;
    }
    public int getId_tarea() {
        return id_tarea;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public int getFlg_invitado() {
        return flg_invitado;
    }
    public int getFlg_participa() {
        return flg_participa;
    }


}
