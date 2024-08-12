package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.Nationality;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class NationalityRepository implements PanacheRepositoryBase<Nationality, UUID> {
}
