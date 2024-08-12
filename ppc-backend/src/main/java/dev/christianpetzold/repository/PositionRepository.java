package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.Position;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class PositionRepository implements PanacheRepositoryBase<Position, UUID> {
}
