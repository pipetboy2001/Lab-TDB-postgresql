package com.tingesogrupo4.apirestappgrupo4.models;


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

    public Integer getId(){
        return id;
    }
    public String getDescription(){
        return descrip;
    }

}
