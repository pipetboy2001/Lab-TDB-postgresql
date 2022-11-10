package com.grupo4TBD.Lab2.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class EstadoTarea {
    //Se establece el modelo para EstadoTarea
    //Se genera un constructor y sus repectivos selectores.
    public Integer id;
    public String descrip;

    public EstadoTarea (Integer id, String descrip){
        this.id= id;
        this.descrip = descrip;
    }
    //Se obtiene el id del estado de la tarea
    public Integer getId(){
        return id;
    } 
    //Se obtiene la descripcion del estado de la tarea
    public String getDescription(){
        return descrip;
    }

}
