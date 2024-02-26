package org.example.ej12_metodos_http_apirest.repository;

import org.example.ej12_metodos_http_apirest.module.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Long> {
}
