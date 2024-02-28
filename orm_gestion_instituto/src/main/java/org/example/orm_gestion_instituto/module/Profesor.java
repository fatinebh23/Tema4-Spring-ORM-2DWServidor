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
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesorid")
    private Integer id_profesor;

    private String segundo_apellido;
    private String primer_apellido;
    private String nombre;
    private Integer telefono;
    private String profesor_direccion;
    @ManyToOne
    @JoinColumn(name = "moduloid", foreignKey = @ForeignKey(name = "fk_profesor_constructor"))
    private Modulo modulos;

    @OneToOne
    @JoinColumn(name = "constructorid", foreignKey = @ForeignKey(name = "fk_profesor_constructor"))
    private Direccion direcciones;

    public void addAttribute(String profesores, List<Profesor> profesores1) {
    }
}
