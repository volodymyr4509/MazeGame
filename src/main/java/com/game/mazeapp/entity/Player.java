package com.game.mazeapp.entity;

import javax.persistence.*;

/**
 * Created by Acer on 11/20/2014.
 */
;
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String nickName;

    @Basic
    private String password;

    @Basic
    private String email;

    @Basic
    private int health;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
