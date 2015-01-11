package com.game.mazeapp.entity;

import javax.persistence.*;

/**
 * Created by Home on 03.01.2015.
 */

@Entity
public class CurrentPlayerStateVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "currentPlayerState_id")
    private CurrentPlayerState currentPlayerState;

    @Column
    private int x;

    @Column
    private int y;

    @Column
    private int currentPlayerHealth;

    @Column
    private int currentPlayerMuscle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrentPlayerState getCurrentPlayerState() {
        return currentPlayerState;
    }

    public void setCurrentPlayerState(CurrentPlayerState currentPlayerState) {
        this.currentPlayerState = currentPlayerState;
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
}
