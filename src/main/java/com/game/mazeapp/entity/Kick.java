package com.game.mazeapp.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Home on 03.01.2015.
 */

@Entity
public class Kick {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany (mappedBy = "kick")
    private List<CurrentPlayerState> playerStateList;

    @Column
    private Integer firstPlayerBlockOn;

    @Column
    private Integer firstPlayerAttackOn;

    @Column
    private Integer firstPlayerDamage;

    @Column
    private Integer secondPlayerBlockOn;

    @Column
    private Integer secondPlayerAttackOn;

    @Column
    private Integer secondPlayerDamage;

    public Kick() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CurrentPlayerState> getPlayerStateList() {
        return playerStateList;
    }

    public void setPlayerStateList(List<CurrentPlayerState> playerStateList) {
        this.playerStateList = playerStateList;
    }

    public Integer getFirstPlayerBlockOn() {
        return firstPlayerBlockOn;
    }

    public void setFirstPlayerBlockOn(Integer firstPlayerBlockOn) {
        this.firstPlayerBlockOn = firstPlayerBlockOn;
    }

    public Integer getFirstPlayerAttackOn() {
        return firstPlayerAttackOn;
    }

    public void setFirstPlayerAttackOn(Integer firstPlayerAttackOn) {
        this.firstPlayerAttackOn = firstPlayerAttackOn;
    }

    public Integer getFirstPlayerDamage() {
        return firstPlayerDamage;
    }

    public void setFirstPlayerDamage(Integer firstPlayerDamage) {
        this.firstPlayerDamage = firstPlayerDamage;
    }

    public Integer getSecondPlayerBlockOn() {
        return secondPlayerBlockOn;
    }

    public void setSecondPlayerBlockOn(Integer secondPlayerBlockOn) {
        this.secondPlayerBlockOn = secondPlayerBlockOn;
    }

    public Integer getSecondPlayerAttackOn() {
        return secondPlayerAttackOn;
    }

    public void setSecondPlayerAttackOn(Integer secondPlayerAttackOn) {
        this.secondPlayerAttackOn = secondPlayerAttackOn;
    }

    public Integer getSecondPlayerDamage() {
        return secondPlayerDamage;
    }

    public void setSecondPlayerDamage(Integer secondPlayerDamage) {
        this.secondPlayerDamage = secondPlayerDamage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kick kick = (Kick) o;

        if (firstPlayerAttackOn != null ? !firstPlayerAttackOn.equals(kick.firstPlayerAttackOn) : kick.firstPlayerAttackOn != null)
            return false;
        if (firstPlayerBlockOn != null ? !firstPlayerBlockOn.equals(kick.firstPlayerBlockOn) : kick.firstPlayerBlockOn != null)
            return false;
        if (firstPlayerDamage != null ? !firstPlayerDamage.equals(kick.firstPlayerDamage) : kick.firstPlayerDamage != null)
            return false;
        if (playerStateList != null ? !playerStateList.equals(kick.playerStateList) : kick.playerStateList != null)
            return false;
        if (secondPlayerAttackOn != null ? !secondPlayerAttackOn.equals(kick.secondPlayerAttackOn) : kick.secondPlayerAttackOn != null)
            return false;
        if (secondPlayerBlockOn != null ? !secondPlayerBlockOn.equals(kick.secondPlayerBlockOn) : kick.secondPlayerBlockOn != null)
            return false;
        if (secondPlayerDamage != null ? !secondPlayerDamage.equals(kick.secondPlayerDamage) : kick.secondPlayerDamage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerStateList != null ? playerStateList.hashCode() : 0;
        result = 31 * result + (firstPlayerBlockOn != null ? firstPlayerBlockOn.hashCode() : 0);
        result = 31 * result + (firstPlayerAttackOn != null ? firstPlayerAttackOn.hashCode() : 0);
        result = 31 * result + (firstPlayerDamage != null ? firstPlayerDamage.hashCode() : 0);
        result = 31 * result + (secondPlayerBlockOn != null ? secondPlayerBlockOn.hashCode() : 0);
        result = 31 * result + (secondPlayerAttackOn != null ? secondPlayerAttackOn.hashCode() : 0);
        result = 31 * result + (secondPlayerDamage != null ? secondPlayerDamage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Kick{" +
                "id=" + id +
                ", playerStateList=" + playerStateList +
                ", firstPlayerBlockOn=" + firstPlayerBlockOn +
                ", firstPlayerAttackOn=" + firstPlayerAttackOn +
                ", firstPlayerDamage=" + firstPlayerDamage +
                ", secondPlayerBlockOn=" + secondPlayerBlockOn +
                ", secondPlayerAttackOn=" + secondPlayerAttackOn +
                ", secondPlayerDamage=" + secondPlayerDamage +
                '}';
    }
}
