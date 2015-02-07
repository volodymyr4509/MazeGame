package com.game.mazeapp.entityJSON;

/**
 * Created by Home on 07.02.2015.
 */
public class StringJSON {
    private String value;

    public StringJSON() {
    }

    public StringJSON(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StringJSON{" +
                "value='" + value + '\'' +
                '}';
    }
}
