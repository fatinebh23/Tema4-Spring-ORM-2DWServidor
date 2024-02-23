package org.example.ej12_metodos_http_apirest.module;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

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

}
