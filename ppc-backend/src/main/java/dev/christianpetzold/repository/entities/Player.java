package dev.christianpetzold.repository.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Table(name = "footballer", schema = "ppc")
public class Player {
    @Id
    @Column(name = "serial")
    private UUID id;

    @Column(name = "f_name")
    private String firstName;

    @Column(name = "l_name")
    private String lastName;

    @Column(name = "known_as")
    private String nickname;

    @Column(name = "date_of_birth")
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "nationality_serial")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "role_serial")
    private Position position;

    @Column(name = "reputation")
    private int fame;

    @Column(name = "currently_active")
    private boolean stillPlaying;
}
