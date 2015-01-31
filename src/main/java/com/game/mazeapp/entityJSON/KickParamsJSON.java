package com.game.mazeapp.entityJSON;

/**
 * Created by Home on 31.01.2015.
 */
public class KickParamsJSON {

    private int block;
    private int attack;

    public KickParamsJSON() {
    }

    public KickParamsJSON(int block, int attack) {
        this.block = block;
        this.attack = attack;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "KickParamsJSON{" +
                "block=" + block +
                ", attack=" + attack +
                '}';
    }
}
