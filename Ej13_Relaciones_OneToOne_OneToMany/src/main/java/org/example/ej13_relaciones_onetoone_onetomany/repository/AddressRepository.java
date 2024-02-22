package org.example.ej13_relaciones_onetoone_onetomany.repository;

import org.example.ej13_relaciones_onetoone_onetomany.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Employee,Long> {
}
