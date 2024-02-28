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
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumnoid")
    private Integer id;

    private String segundo_apellido;
    private String primer_apellido;
    private Integer nia;
    private String nombre;
    private Integer telefono;

    @ManyToMany
    @JoinTable(name = "alumno_modulo",
            joinColumns = @JoinColumn(name = "alumnoid", referencedColumnName = "alumnoid"),
            inverseJoinColumns = @JoinColumn(name = "racesid", referencedColumnName = "moduloid"))
    private List<Modulo> races =  new ArrayList<Modulo>();


    public void addAttribute(String drivers, List<Alumno> drivers1) {
    }
}
