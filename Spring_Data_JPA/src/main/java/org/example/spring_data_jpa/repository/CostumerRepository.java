package org.example.spring_data_jpa.repository;

import jakarta.persistence.Entity;
import org.example.spring_data_jpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<Customer,Long> {


}
