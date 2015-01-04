package com.game.mazeapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Home on 03.01.2015.
 */

@Entity
public class CurrentPlayerState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Player player;

    private int x;

    private int y;

    private int currentPlayerHealth;

    private int currentPlayerMuscle;

}
