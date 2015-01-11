package com.game.mazeapp.entity;

import javax.persistence.*;

/**
 * Created by Home on 03.01.2015.
 */

@Entity
public class CurrentPlayerState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "currentPlayerState", cascade = CascadeType.ALL)
    private Player player;

    @Column
    private int x;

    @Column
    private int y;

    @Column
    private int currentPlayerHealth;

    @Column
    private int currentPlayerMuscle;

    @OneToOne(mappedBy = "currentPlayerState")
    private Kick kick;

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCurrentPlayerHealth() {
        return currentPlayerHealth;
    }

    public void setCurrentPlayerHealth(int currentPlayerHealth) {
        this.currentPlayerHealth = currentPlayerHealth;
    }

    public int getCurrentPlayerMuscle() {
        return currentPlayerMuscle;
    }

    public void setCurrentPlayerMuscle(int currentPlayerMuscle) {
        this.currentPlayerMuscle = currentPlayerMuscle;
    }

    public Kick getKick() {
        return kick;
    }

    public void setKick(Kick kick) {
        this.kick = kick;
    }
}
