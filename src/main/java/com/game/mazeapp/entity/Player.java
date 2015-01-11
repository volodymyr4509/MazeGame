package com.game.mazeapp.entity;

import javax.persistence.*;

/**
 * Created by Acer on 11/20/2014.
 */

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerDetails_id")
    private PlayerDetails playerDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currentPlayerState_id")
    private CurrentPlayerState currentPlayerState;

    @Column(length = 20 ,unique = true)
    private String nickName;

    @Column(length = 50)
    private String password;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerDetails getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(PlayerDetails playerDetails) {
        this.playerDetails = playerDetails;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CurrentPlayerState getCurrentPlayerState() {
        return currentPlayerState;
    }

    public void setCurrentPlayerState(CurrentPlayerState currentPlayerState) {
        this.currentPlayerState = currentPlayerState;
    }
}
