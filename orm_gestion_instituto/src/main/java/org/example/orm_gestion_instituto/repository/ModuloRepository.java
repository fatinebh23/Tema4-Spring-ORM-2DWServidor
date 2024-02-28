package org.example.orm_gestion_instituto.repository;

import org.example.orm_gestion_instituto.module.Alumno;
import org.example.orm_gestion_instituto.module.Modulo;
import org.example.orm_gestion_instituto.module.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuloRepository  extends JpaRepository<Modulo, Long> {
    Optional<Modulo> findByIdIgnoreCase(Integer id);
}
