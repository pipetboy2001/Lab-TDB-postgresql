package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {

    //Generacion de firmas para consumir desde services.
    Voluntario createVoluntario(Voluntario Voluntario);
    Voluntario getVoluntarioById(Integer id);

    List<Voluntario> getAllVoluntarios();
    Voluntario updateVoluntario(Voluntario Voluntario);
    void deleteVoluntarioById(Integer id);

    void deleteVoluntarios();

    Integer generateId();


    void generateViewByIdEmergencia(String inputId);
}
