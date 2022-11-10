package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.Institucion;

import java.util.List;

public interface InstitucionRepository {

    //Generacion de firmas para consumir desde services.
    Institucion createInstitucion(Institucion institucion);
    Institucion getInstitucionById(Integer id);

    List<Institucion> getAllInstituciones();
    Institucion updateInstitucion(Institucion institucion);
    void deleteInstitucionById(Integer id);

    void deleteInstituciones();

    Integer generateId();


}
