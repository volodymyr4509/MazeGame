package com.game.mazeapp.entity;

import javax.persistence.*;

/**
 * Created by Home on 03.01.2015.
 */

@Entity
public class PlayerDetailsVersion {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playerDetails_id")
    private PlayerDetails playerDetails;

    @Column
    private int healthVersion;

    @Column
    private int muscleVersion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHealthVersion() {
        return healthVersion;
    }
    public void setHealthVersion(int healthVersion) {
        this.healthVersion = healthVersion;
    }

    public int getMuscleVersion() {
        return muscleVersion;
    }

    public void setMuscleVersion(int muscleVersion) {
        this.muscleVersion = muscleVersion;
    }

    public PlayerDetails getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(PlayerDetails playerDetails) {
        this.playerDetails = playerDetails;
    }
}
