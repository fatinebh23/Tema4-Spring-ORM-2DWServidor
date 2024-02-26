package org.example.ej12_metodos_http_apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Constructor;
@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {
}
