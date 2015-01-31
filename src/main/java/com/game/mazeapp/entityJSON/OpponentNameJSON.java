package com.game.mazeapp.entityJSON;

/**
 * Created by Home on 31.01.2015.
 */
public class OpponentNameJSON {

    private String monsterNickname;

    public OpponentNameJSON() {
    }

    public OpponentNameJSON(String monsterNickname) {
        this.monsterNickname = monsterNickname;
    }

    public String getMonsterNickname() {
        return monsterNickname;
    }

    public void setMonsterNickname(String monsterNickname) {
        this.monsterNickname = monsterNickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpponentNameJSON that = (OpponentNameJSON) o;

        if (monsterNickname != null ? !monsterNickname.equals(that.monsterNickname) : that.monsterNickname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return monsterNickname != null ? monsterNickname.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OpponentName{" +
                "monsterNickname='" + monsterNickname + '\'' +
                '}';
    }
}
