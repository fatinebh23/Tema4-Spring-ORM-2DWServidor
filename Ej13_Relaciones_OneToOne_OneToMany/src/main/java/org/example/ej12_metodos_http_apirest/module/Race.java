package org.example.ej12_metodos_http_apirest.module;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private String name;
    private LocalDate date;
    private LocalDateTime time;
    private String url;

    @OneToOne
    @JoinColumn(name = "cricuitid", foreignKey = @ForeignKey(name = "fk_races_circuits"))
    private Circuit circuit;
    @ManyToMany(mappedBy = "races")
    private List<Driver> drivers = new ArrayList<>();
}