package org.example.orm_gestion_instituto.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name = "modulos")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moduloid")
    private Integer id;

    private String curso;
    private Integer horas;
    private String nombre;


    private String id_profesor;



    @ManyToMany(mappedBy = "modulos")
    private List<Alumno> alumnos = new ArrayList<>();

    public void addAttribute(String modulos, List<Modulo> modulos1) {
    }
}
