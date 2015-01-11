package com.game.mazeapp.entity;

import javax.persistence.*;

/**
 * Created by Home on 03.01.2015.
 */

@Entity
public class Kick {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "firstPlayerState_id")
    private CurrentPlayerState firstPlayer;

    @Column
    private Integer firstPlayerBlockOn;

    @Column
    private Integer firstPlayerAttackOn;

    @Column
    private Integer firstPlayerDamage;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "secondPlayerState_id")
    private CurrentPlayerState secondPlayer;

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

    public CurrentPlayerState getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(CurrentPlayerState firstPlayer) {
        this.firstPlayer = firstPlayer;
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

    public CurrentPlayerState getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(CurrentPlayerState secondPlayer) {
        this.secondPlayer = secondPlayer;
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
