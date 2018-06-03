package org.academiadecodigo.bootcamp.Interfaces;

/**
 * Created by codecadet on 02/06/2018.
 */
public enum CharactersType {
    PLAYER(100, 10),
    ENEMY(50, 10);

    private int health;
    private int speed;

    CharactersType(int health, int speed) {
        this.health = health;
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }
}
