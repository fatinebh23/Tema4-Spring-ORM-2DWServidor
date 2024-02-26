package org.example.ej12_metodos_http_apirest.module;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "constructors")
public class Constructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructorid")
    private Long constructorid;
    @Column(unique = true)
    private String constructorref;
    private String name;
    private String nationality;
    private String url;

    @OneToMany(mappedBy = "constructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Driver> drivers =  new ArrayList<>();

}