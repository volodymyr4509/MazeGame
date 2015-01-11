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
}
