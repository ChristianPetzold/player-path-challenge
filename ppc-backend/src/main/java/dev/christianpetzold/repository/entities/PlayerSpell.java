package dev.christianpetzold.repository.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "footballer_tenure", schema = "ppc")
public class PlayerSpell {

    @Id
    @Column(name = "serial")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "footballer_serial")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_serial")
    private Club club;

    @Column(name = "year_of_arrival")
    private Integer arrivalYear;

    @Column(name = "month_of_arrival")
    private Integer arrivalMonth;

    @Column(name = "year_of_departure")
    private Integer departureYear;

    @Column(name = "month_of_departure")
    private Integer departureMonth;
}
