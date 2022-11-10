package com.grupo4TBD.Lab2.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class RankingByTarea {
    //Se establece el modelo para institucion
    //Se genera un constructor y sus repectivos selectores.
   public int emergencia;
   public int id_tarea;
   public String nombre_tarea;
   public int cant_vol_requeridos;
   public int id_voluntario;
   public int puntaje;

    public RankingByTarea(int emergencia, int id_tarea, String nombre_tarea, int cant_vol_requeridos, int id_voluntario, int puntaje) {
         this.emergencia = emergencia;
         this.id_tarea = id_tarea;
         this.nombre_tarea = nombre_tarea;
         this.cant_vol_requeridos = cant_vol_requeridos;
         this.id_voluntario = id_voluntario;
         this.puntaje = puntaje;
    }
    //Se obtiene el id de la emergencia
    public int getId() {
        return emergencia;
    }
    //Se obtiene el id de la tarea
    public int getId_tarea() {
        return id_tarea;
    }
    //Se obtiene el nombre de la tarea
    public String getNombre_tarea() {
        return nombre_tarea;
    }

}
