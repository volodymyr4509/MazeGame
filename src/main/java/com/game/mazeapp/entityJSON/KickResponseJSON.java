package com.game.mazeapp.entityJSON;

import com.game.mazeapp.entity.Fight;
import com.game.mazeapp.entity.Player;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Home on 08.03.2015.
 */
public class KickResponseJSON {
    private Player hero;
    private Player monster;

    public KickResponseJSON(Fight fight) {
        Set<Player> players = fight.getPlayers();
        Iterator<Player> i = players.iterator();
        Player h = null;
        Player m = null;
        if(i.hasNext()){
            h = i.next();
        }
        if (i.hasNext()){
            m = i.next();
        }
        this.hero = h;
        this.monster = m;
    }

    public KickResponseJSON() {
    }

    public Player getHero() {
        return hero;
    }

    public void setHero(Player hero) {
        this.hero = hero;
    }

    public Player getMonster() {
        return monster;
    }

    public void setMonster(Player monster) {
        this.monster = monster;
    }

    @Override
    public String toString() {
        return "KickResponseJSON{" +
                "hero=" + hero +
                ", monster=" + monster +
                '}';
    }
}
