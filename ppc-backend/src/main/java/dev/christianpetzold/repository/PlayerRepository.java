package dev.christianpetzold.repository;

import dev.christianpetzold.repository.entities.Player;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class PlayerRepository implements PanacheRepositoryBase<Player, UUID> {
    public Player findRandom(){
        return find("ORDER BY RANDOM()").firstResult();
    }
}
