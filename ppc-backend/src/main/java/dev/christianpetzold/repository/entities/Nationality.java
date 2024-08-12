package dev.christianpetzold.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Table(name = "nationality", schema="ppc")
public class Nationality {

    @Id
    @Column(name = "serial")
    private UUID id;

    @Column(name = "abbreviated_name")
    private String abbreviatedName;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "banner_file_name")
    private String bannerFileName;
}
