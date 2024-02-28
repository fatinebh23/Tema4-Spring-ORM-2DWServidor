package org.example.orm_gestion_instituto.service;

import org.example.orm_gestion_instituto.module.Profesor;

import java.util.List;

public interface ProfesorService {

    List<Profesor> getAllProfesores();

    void saveProfesor(Profesor profesor);
}
