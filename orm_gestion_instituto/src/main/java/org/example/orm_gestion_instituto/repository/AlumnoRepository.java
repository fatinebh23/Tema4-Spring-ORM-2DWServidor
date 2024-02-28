package org.example.orm_gestion_instituto.repository;

import org.example.orm_gestion_instituto.module.Alumno;
import org.example.orm_gestion_instituto.module.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository  extends JpaRepository<Alumno, Long> {

    Optional<Alumno> findByNiaIgnoreCase(String nia);



}
