package org.example.ej12_metodos_http_apirest.module;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "drivers")

public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long driverId;

    @Column(unique = true)
    private String code;
    private String forename;
    private String surname;

    @JsonProperty("dateOfBirth")
    private LocalDate dob;
    private String nationality;
    private String url;
    @ManyToMany
    @JoinTable(name = "driver_races",
            joinColumns = @JoinColumn(name = "driverid", referencedColumnName = "driverid"),
            inverseJoinColumns = @JoinColumn(name = "racesid", referencedColumnName = "racesid"))
    private List<Race> races =  new ArrayList<Race>();
    @ManyToOne
    @JoinColumn(name = "constructorid", foreignKey = @ForeignKey(name = "fk_driver_constructor"))
    private Constructor constructor;
}
