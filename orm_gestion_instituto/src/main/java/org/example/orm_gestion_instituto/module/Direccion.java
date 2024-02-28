package org.example.orm_gestion_instituto.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name = "direcciones")
public class Direccion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccionid")
    private Integer id;

    private String calle;
    private Integer numero;
    private String poblacion;
    private String provincia;
    @OneToOne(mappedBy = "direccion", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("direccion")
    private Profesor profesores;

    public void addAttribute(String direcciones, List<Direccion> direcciones1) {
    }
}
