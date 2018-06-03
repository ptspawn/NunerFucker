package org.academiadecodigo.bootcamp.Projectiles;

import org.academiadecodigo.bootcamp.Interfaces.ProjectileType;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Bullet extends Projectile implements Drawable, Movable {

    public Bullet() {
        super(ProjectileType.BULLET.getDamage(), ProjectileType.BULLET.getSpeed());
    }

    @Override
    public void move(double[] vector) {

    }

    @Override
    public void move(boolean[] directions, double[] orientation) {

    }

    @Override
    public void draw() {
        Rectangle bullet = new Rectangle(100,50,10,5);
            bullet.fill();
            bullet.setColor(Color.RED);
    }

    @Override
    public String toString() {
        return "Bullet{ damage: " + getDamage() + " speed: " + getSpeed() + " }" ;
    }
}
