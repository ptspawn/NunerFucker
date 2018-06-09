package org.academiadecodigo.bootcamp.Projectiles;

import org.academiadecodigo.bootcamp.Interfaces.Collidable;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Projectile implements Movable, Drawable, Collidable {

    private double[] vectorDirection;
    private int speed;
    private int damage;
    private int fireRate;
    private double collisionRadius;


    public Projectile(double[] vectorDirection, int damage, int speed, int fireRate) {
        this.vectorDirection = vectorDirection;
        this.speed = speed;
        this.damage = damage;
        this.fireRate = fireRate;
    }


    @Override
    public void setDirection(double[] vector) {

    }

    @Override
    public void preLoadGraphics() {

    }

    @Override
    public int getCollisionRadius() {
        return 0;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getFireRate() {
        return fireRate;
    }
}
