package com.game.mazeapp.entity;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Home on 13.12.2014.
 */

@Entity
public class PlayerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //delete mappedBy to allow bidirectional relations
    @OneToOne(mappedBy = "playerDetails", cascade = CascadeType.ALL)
    public Player player;

    @Column
    private int health;

    @Column
    private int muscle;

    public PlayerDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMuscle() {
        return muscle;
    }

    public void setMuscle(int muscle) {
        this.muscle = muscle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerDetails that = (PlayerDetails) o;

        if (health != that.health) return false;
        if (muscle != that.muscle) return false;
        if (!player.equals(that.player)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = player.hashCode();
        result = 31 * result + health;
        result = 31 * result + muscle;
        return result;
    }

    @Override
    public String toString() {
        return "PlayerDetails{" +
                "id=" + id +
                ", player=" + player +
                ", health=" + health +
                ", muscle=" + muscle +
                '}';
    }
}
