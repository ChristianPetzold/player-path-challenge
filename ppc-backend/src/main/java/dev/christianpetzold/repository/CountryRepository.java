package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.Country;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class CountryRepository implements PanacheRepositoryBase<Country, UUID> {
}
