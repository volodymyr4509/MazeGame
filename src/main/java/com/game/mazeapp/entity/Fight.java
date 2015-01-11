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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }


}
