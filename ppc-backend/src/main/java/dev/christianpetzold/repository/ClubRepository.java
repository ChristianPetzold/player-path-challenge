package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.Club;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ClubRepository implements PanacheRepositoryBase<Club, UUID> {
}
