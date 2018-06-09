package org.academiadecodigo.bootcamp.enums;

/**
 * Created by codecadet on 02/06/2018.
 */
public enum ProjectileType {
    BULLET(100, 20,20);

    private int damage;
    private int speed;
    private int fireRate;

    ProjectileType(int damage, int speed, int fireRate) {
        this.damage = damage;
        this.speed = speed;
        this.fireRate=fireRate;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFireRate() {
        return fireRate;
    }
}
