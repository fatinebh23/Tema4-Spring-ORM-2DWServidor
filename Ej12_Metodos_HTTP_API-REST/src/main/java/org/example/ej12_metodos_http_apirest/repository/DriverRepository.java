package org.example.ej12_metodos_http_apirest.repository;

import org.example.ej12_metodos_http_apirest.module.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//Aquí,
//findByCodeIgnoreCase es un nombre de método especial que Spring Data JPA interpreta para generar
//automáticamente la consulta que queremos.
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver>findByCodeIgnoreCase(String code);

    void deleteDriverByCode(String code);
}