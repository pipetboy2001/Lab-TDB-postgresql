package com.grupo4TBD.Lab2.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class RankingVoluntarios {
    public Integer id;

    public int id_emergencia;

    public String tarea;

    public int cant_vol_req;

    public int id_vol;

    public int puntaje;

    public RankingVoluntarios(int id_emergencia, String tarea, int cant_vol_req, int id_vol, int puntaje) {
        this.id_emergencia = id_emergencia;
        this.tarea = tarea;
        this.cant_vol_req = cant_vol_req;
        this.id_vol = id_vol;
        this.puntaje = puntaje;
    }
       
    public int getId() {    return id;  }

    public int getId_emergencia() {     return id_emergencia;   }

    public String getTarea() {        return tarea;    }

    public int getCant_vol_req() {        return cant_vol_req;    }

    public int getId_vol() {        return id_vol;    }

    public int getPuntaje() {        return puntaje;    }

    public void setId(int id) {        this.id = id;    }

    public void setId_emergencia(int id_emergencia) {        this.id_emergencia = id_emergencia;    }

    public void setTarea(String tarea) {        this.tarea = tarea;    }

    public void setCant_vol_req(int cant_vol_req) {        this.cant_vol_req = cant_vol_req;    }

    public void setId_vol(int id_vol) {        this.id_vol = id_vol;    }

    public void setPuntaje(int puntaje) {        this.puntaje = puntaje;    }
}
