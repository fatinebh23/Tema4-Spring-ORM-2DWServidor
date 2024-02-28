package org.example.orm_gestion_instituto.service;

import org.example.orm_gestion_instituto.module.Profesor;
import org.example.orm_gestion_instituto.repository.ProfesorRepository;

import java.util.List;

public class ProfesorServiceImpl  implements ProfesorService {
    private final ProfesorRepository repository;


    public ProfesorServiceImpl(ProfesorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Profesor> getAllProfesores() {
        return null;
    }

    @Override
    public void saveProfesor(Profesor profesor) {
        this.repository.save(profesor);
    }








}
