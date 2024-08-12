package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.PlayerSpell;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class PlayerSpellRepository implements PanacheRepositoryBase<PlayerSpell, UUID> {
}
