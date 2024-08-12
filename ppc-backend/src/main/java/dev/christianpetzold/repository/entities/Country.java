package dev.christianpetzold.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name = "nationality", schema = "ppc")
public class Country {
    @Id
    @Column(name = "serial")
    private UUID id;

    @Column(name = "abbreviated_name")
    private String abbreviation;

    @Column(name = "f_name")
    private String name;

    @Column(name = "banner_file_name")
    private String flagFileName;
}
