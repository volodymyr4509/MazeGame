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

    @Column
    private boolean inFight;

    @ManyToOne
    @JoinColumn(name = "kick_id")
    private Kick kick;

    public CurrentPlayerState() {
    }

    public boolean isInFight() {
        return inFight;
    }

    public void setInFight(boolean inFight) {
        this.inFight = inFight;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentPlayerState that = (CurrentPlayerState) o;

        if (currentPlayerHealth != that.currentPlayerHealth) return false;
        if (currentPlayerMuscle != that.currentPlayerMuscle) return false;
        if (inFight != that.inFight) return false;
        if (x != that.x) return false;
        if (y != that.y) return false;
        if (kick != null ? !kick.equals(that.kick) : that.kick != null) return false;
        if (!player.equals(that.player)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = player.hashCode();
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + currentPlayerHealth;
        result = 31 * result + currentPlayerMuscle;
        result = 31 * result + (inFight ? 1 : 0);
        result = 31 * result + (kick != null ? kick.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrentPlayerState{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", currentPlayerHealth=" + currentPlayerHealth +
                ", currentPlayerMuscle=" + currentPlayerMuscle +
                ", inFight=" + inFight +
                ", kick=" + kick +
                '}';
    }
}
