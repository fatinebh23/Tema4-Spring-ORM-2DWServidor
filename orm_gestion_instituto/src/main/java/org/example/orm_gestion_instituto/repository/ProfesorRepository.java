package org.example.orm_gestion_instituto.repository;

import org.example.orm_gestion_instituto.module.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    void deleteProfesorById(Integer id);

}
