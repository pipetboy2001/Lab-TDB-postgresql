package com.tingesogrupo4.apirestappgrupo4.repositories;

import com.tingesogrupo4.apirestappgrupo4.models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    Integer generateIdEmergencia();

    Emergencia createEmergencia(Emergencia emergencia);

    Emergencia getEmergenciaById(Integer id);

    List<Emergencia> getAllEmergencia();

    Emergencia updateEmergencia(Emergencia emergencia);

    void deleteEmergenciaById(Integer id);

    void deleteEmergencia();
}
