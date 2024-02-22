package org.example.ej13_relaciones_onetoone_onetomany.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;
    private LocalDate deliviryDate;
    @ManyToMany(mappedBy = "projects")
    private List<Employee>employees=new ArrayList<>();

    public Project() {
    }

    public Project(Long id, String name, LocalDate deliviryDate, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.deliviryDate = deliviryDate;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeliviryDate() {
        return deliviryDate;
    }

    public void setDeliviryDate(LocalDate deliviryDate) {
        this.deliviryDate = deliviryDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deliviryDate=" + deliviryDate +
                ", employees=" + employees +
                '}';
    }
}
