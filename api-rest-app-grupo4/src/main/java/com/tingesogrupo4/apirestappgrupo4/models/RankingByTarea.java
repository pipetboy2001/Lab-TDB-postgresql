package com.tingesogrupo4.apirestappgrupo4.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class RankingByTarea {
   public int id;
   public int id_tarea;
   public String nombre_tarea;
   public int cant_vol_requeridos;
   public int id_voluntario;
   public int puntaje;

    public RankingByTarea(int id, int id_tarea, String nombre_tarea, int cant_vol_requeridos, int id_voluntario, int puntaje) {
         this.id = id;
         this.id_tarea = id_tarea;
         this.nombre_tarea = nombre_tarea;
         this.cant_vol_requeridos = cant_vol_requeridos;
         this.id_voluntario = id_voluntario;
         this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }
    public int getId_tarea() {
        return id_tarea;
    }
    public String getNombre_tarea() {
        return nombre_tarea;
    }

}
