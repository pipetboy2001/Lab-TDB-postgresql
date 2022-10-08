package com.tingesogrupo4.apirestappgrupo4.models;


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

    //Se crea el metodo addDay para agregar un dia a la fecha de inicio y fin, ya que
    //postgres tiene otro timezone y las fechas se agregan incorrectamente.
    public Date addDay(Date fecha){
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.plusDays(1);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

    }

    public Tarea (Integer id, String nombre, String descrip, Integer cantidad_vol_requeridos, Integer cantidad_vol_inscritos, Integer id_emergencia, Date finicio, Date ffin, Integer id_estado){
        this.id= id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.cant_vol_requeridos = cantidad_vol_requeridos;
        this.cant_vol_inscritos = cantidad_vol_inscritos;
        this.id_emergencia = id_emergencia;
        this.finicio = addDay(finicio);
        this.ffin = addDay(ffin);
        this.id_estado = id_estado;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return nombre;
    }
    public String getDescription(){
        return descrip;
    }
    public Integer getIdEstadoTarea(){
        return id_estado;
    }
    public Integer getIdEmergencia(){
        return id_emergencia;
    }
    public Integer getCantidadVolRequeridos(){
        return cant_vol_requeridos;
    }
    public Integer getCantidadVolInscritos(){
        return cant_vol_inscritos;
    }

    public Date getFechaInicio()  {
        return finicio;

    }
    public Date getFechaFin(){
            return ffin;

    }

}
