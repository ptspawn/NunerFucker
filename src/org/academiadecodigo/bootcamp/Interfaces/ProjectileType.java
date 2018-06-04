package org.academiadecodigo.bootcamp.Interfaces;

/**
 * Created by codecadet on 02/06/2018.
 */
public enum ProjectileType {
    BULLET(10, 5);

    private int damage;
    private int speed;

    ProjectileType(int damage, int speed) {
        this.damage = damage;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }
}
