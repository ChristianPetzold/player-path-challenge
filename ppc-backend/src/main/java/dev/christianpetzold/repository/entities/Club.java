package dev.christianpetzold.repository.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Table(name = "team", schema="ppc")
public class Club {
    @Id
    @Column(name = "serial")
    private UUID id;

    @Column(name = "title")
    private String name;

    @ManyToOne
    @JoinColumn(name = "nationality_serial")
    private Country country;
}
