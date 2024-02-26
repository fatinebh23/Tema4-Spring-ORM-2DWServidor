package org.example.ej12_metodos_http_apirest.module;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

@Table(name = "circuits")
public class Circuit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructorid")
    private Long circuitid;
    @Column(unique = true)
    private String circuitref;
    private String name;
    private String location;
    private String country;
    private Double lat;
    private Double lng;
    private Integer alt;
    private String url;

}
