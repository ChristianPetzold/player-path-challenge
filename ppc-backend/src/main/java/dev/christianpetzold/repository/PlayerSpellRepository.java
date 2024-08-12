package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.Player;
import dev.christianpetzold.repository.entities.PlayerSpell;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PlayerSpellRepository implements PanacheRepositoryBase<PlayerSpell, UUID> {
    public List<PlayerSpell> findByPlayer(Player player) {
        return list("player", player);
    }
}
