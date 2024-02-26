package org.example.ej12_metodos_http_apirest.module;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity


@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raceid")
    private Long raceid;
    private Integer year;
    private Integer round;

    // tipo de relación
    // un empleado tiene una dirección
    // one-to-one
    @OneToOne
    @JoinColumn(name = "circuitid", foreignKey = @ForeignKey(name = "fk_race_circuit"))
    private Circuit circuit;

    // private Integer circuitid;
    private String name;
    private LocalDate date;
    private LocalDateTime time;
    private String url;
}