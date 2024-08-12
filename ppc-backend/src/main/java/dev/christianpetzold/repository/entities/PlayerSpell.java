package dev.christianpetzold.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

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
    private int arrivalYear;

    @Column(name = "month_of_arrival")
    private int arrivalMonth;

    @Column(name = "year_of_departure")
    private int departureYear;

    @Column(name = "month_of_departure")
    private int departureMonth;
}
