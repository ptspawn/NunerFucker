package org.academiadecodigo.bootcamp.Projectiles;

import org.academiadecodigo.bootcamp.Interfaces.ProjectileType;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Bullet extends Projectile implements Drawable, Movable {

    public Bullet() {
        super(ProjectileType.BULLET.getDamage(), ProjectileType.BULLET.getSpeed());
    }

    @Override
    public void move() {

    }

    @Override
    public void draw() {

    }

    @Override
    public String toString() {
        return "Bullet{ damage: " + getDamage() + " speed: " + getSpeed() + " }" ;
    }
}
