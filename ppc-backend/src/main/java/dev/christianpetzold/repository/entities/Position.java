package dev.christianpetzold.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "role", schema = "ppc")
public class Position {
    @Id
    @Column(name = "serial")
    private UUID id;

    @Column(name = "abbreviated_name")
    private String abbreviation;

    @Column(name = "full_name")
    private String name;
}
