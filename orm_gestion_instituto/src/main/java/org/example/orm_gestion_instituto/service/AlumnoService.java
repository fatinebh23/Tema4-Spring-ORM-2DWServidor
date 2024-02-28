package org.example.orm_gestion_instituto.service;

import org.example.orm_gestion_instituto.module.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    Optional<Alumno> findByNiaIgnoreCase(String nia);
    //listar alumnos
    List<Alumno> getAllAlumnos();

    void saveDriver(Alumno alumno);
    void deleteByCode(String code);
}
