package org.academiadecodigo.bootcamp.Projectiles;

import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Projectile implements Movable, Drawable{

    private double[] vectorDirection;
    private int speed;
    private int damage;

    //todo: need to set vectorDirection

    public Projectile(/*double[] vectorDirection,*/ int damage, int speed) {
        this.vectorDirection = vectorDirection;
        this.speed = speed;
        this.damage = damage;
    }


    @Override
    public void setDirection(double[] vector) {

    }

    @Override
    public void preLoadGraphics() {

    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }
}
