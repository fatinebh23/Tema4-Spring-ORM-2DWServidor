package org.example.orm_gestion_instituto.repository;

import org.example.orm_gestion_instituto.module.Direccion;
import org.example.orm_gestion_instituto.module.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository  extends JpaRepository<Direccion, Long> {
    void deleteDireccionByCalle(String calle);
}
