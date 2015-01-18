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

    public CurrentPlayerStateVersion() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentPlayerStateVersion that = (CurrentPlayerStateVersion) o;

        if (currentPlayerHealth != that.currentPlayerHealth) return false;
        if (currentPlayerMuscle != that.currentPlayerMuscle) return false;
        if (x != that.x) return false;
        if (y != that.y) return false;
        if (!currentPlayerState.equals(that.currentPlayerState)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = currentPlayerState.hashCode();
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + currentPlayerHealth;
        result = 31 * result + currentPlayerMuscle;
        return result;
    }

    @Override
    public String toString() {
        return "CurrentPlayerStateVersion{" +
                "id=" + id +
                ", currentPlayerState=" + currentPlayerState +
                ", x=" + x +
                ", y=" + y +
                ", currentPlayerHealth=" + currentPlayerHealth +
                ", currentPlayerMuscle=" + currentPlayerMuscle +
                '}';
    }
}
