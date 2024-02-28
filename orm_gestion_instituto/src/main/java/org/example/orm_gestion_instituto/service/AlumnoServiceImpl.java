package org.example.orm_gestion_instituto.service;

import org.example.orm_gestion_instituto.module.Alumno;
import org.example.orm_gestion_instituto.repository.AlumnoRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class AlumnoServiceImpl implements AlumnoService{

    private final AlumnoRepository repository;

    @Override
    public Optional<Alumno> findByNiaIgnoreCase(String nia) {
        return repository.findByNiaIgnoreCase(nia);
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        return null;
    }
    @Override
    public void saveDriver(Alumno alumno) {
        this.repository.save(alumno);
    }

    @Override
    public void deleteByCode(String code) {

    }


    public AlumnoServiceImpl(AlumnoRepository repository) {
        this.repository = repository;
    }
}
