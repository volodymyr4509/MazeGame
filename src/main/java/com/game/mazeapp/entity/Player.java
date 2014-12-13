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


    @Basic
    @Column(unique = true)
    private String nickName;


    @Basic
    private String password;

    @Basic
    private String email;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private PlayerSpecifications playerSpecification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerSpecifications getPlayerSpecification() {
        return playerSpecification;
    }

    public void setPlayerSpecification(PlayerSpecifications playerSpecification) {
        this.playerSpecification = playerSpecification;
    }

    public String getPassword() {return password; }

    public void setPassword(String password) { this.password = password; }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
