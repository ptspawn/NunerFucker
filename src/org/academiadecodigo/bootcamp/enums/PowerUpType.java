package org.academiadecodigo.bootcamp.enums;

public enum PowerUpType {
    HEALTH(10);

    private int value;

    PowerUpType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
