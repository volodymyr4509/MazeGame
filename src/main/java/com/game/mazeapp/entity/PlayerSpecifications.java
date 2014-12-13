package com.game.mazeapp.entity;


import javax.persistence.*;

/**
 * Created by Home on 13.12.2014.
 */

@Entity
public class PlayerSpecifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    public Player player;

    @Basic
    @Column(columnDefinition = "int default 100")
    private int health;

    @Basic
    @Column(columnDefinition = "int default 100")
    private int muscle;

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

}
