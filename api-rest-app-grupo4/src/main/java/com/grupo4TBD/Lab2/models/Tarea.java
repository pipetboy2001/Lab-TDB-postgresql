package com.grupo4TBD.Lab2.models;


import net.bytebuddy.asm.Advice;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@EntityScan
public class Tarea {
    //Se establece el modelo para Tarea
    //Se genera un constructor y sus repectivos selectores.
    public Integer id;
    public String nombre;
    public String descrip;
    public Integer cant_vol_requeridos;
    public Integer cant_vol_inscritos;
    public Integer id_emergencia;
    public Date finicio;
    public Date ffin;
    public Integer id_estado;
    public float longitud;
    public float latitud;
    public String geom;

    //Se crea el metodo addDay para agregar un dia a la fecha de inicio y fin, ya que
    //postgres tiene otro timezone y las fechas se agregan incorrectamente.
    public Date addDay(Date fecha){
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.plusDays(1);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

    }

    public Tarea (Integer id, String nombre, String descrip, Integer cantidad_vol_requeridos, Integer cantidad_vol_inscritos, Integer id_emergencia, Date finicio, Date ffin, Integer id_estado, Integer longitud, Integer latitud, String geom){
        this.id= id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.cant_vol_requeridos = cantidad_vol_requeridos;
        this.cant_vol_inscritos = cantidad_vol_inscritos;
        this.id_emergencia = id_emergencia;
        this.finicio = addDay(finicio);
        this.ffin = addDay(ffin);
        this.id_estado = id_estado;
        this.longitud = longitud;
        this.latitud = latitud;
        this.geom = geom;
    }
    //Se obtiene el id de la tarea
    public Integer getId(){
        return id;
    }
    //Se obtiene el nombre de la tarea
    public String getName(){
        return nombre;
    }
    //Se obtiene la descripcion de la tarea
    public String getDescription(){
        return descrip;
    }
    //Se obtiene el id del EstadoTarea
    public Integer getIdEstadoTarea(){
        return id_estado;
    }
    //Se obtiene el id de la emergencia
    public Integer getIdEmergencia(){
        return id_emergencia;
    }
    //Se obtiene la cantidad de voluntarios requeridos
    public Integer getCantidadVolRequeridos(){
        return cant_vol_requeridos;
    }
    //Se obtiene la cantidad de voluntarios inscritos
    public Integer getCantidadVolInscritos(){
        return cant_vol_inscritos;
    }
    //Se obtiene la fecha de inicio de la tarea
    public Date getFechaInicio()  {
        return finicio;

    }
    //Se obtiene la fecha de fin de la tarea
    public Date getFechaFin(){
            return ffin;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
