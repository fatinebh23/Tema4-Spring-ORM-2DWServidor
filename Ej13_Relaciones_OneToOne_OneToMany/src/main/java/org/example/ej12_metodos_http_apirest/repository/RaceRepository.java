package org.example.ej12_metodos_http_apirest.repository;

import org.example.ej12_metodos_http_apirest.module.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RaceRepository extends JpaRepository<Race, Long> {
}
