package com.game.mazeapp.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Acer on 1/11/2015.
 */

@Entity
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Player> players;

    public Fight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fight fight = (Fight) o;

        if (!players.equals(fight.players)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return players.hashCode();
    }

    @Override
    public String toString() {
        return "Fight{" +
                "id=" + id +
                ", players=" + players +
                '}';
    }
}
