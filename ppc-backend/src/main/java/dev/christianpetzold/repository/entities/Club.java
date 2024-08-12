package dev.christianpetzold.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
