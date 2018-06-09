package org.academiadecodigo.bootcamp.Projectiles;

import org.academiadecodigo.bootcamp.Interfaces.Collidable;
import org.academiadecodigo.bootcamp.enums.ProjectileType;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.getRotationFromVector;
import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.normalizedVector;


/**
 * Created by codecadet on 02/06/2018.
 */
public class Bullet extends Projectile implements Drawable, Movable, Collidable {

    private double xPos;
    private double yPos;
    private Picture bullet;
    private double[] screenDim;
    private double[] orientation;
    private double collisionRadius;

    public Bullet(double xPos, double yPos, double[] orientation) {
        super(orientation, ProjectileType.BULLET.getDamage(), ProjectileType.BULLET.getSpeed(), ProjectileType.BULLET.getFireRate());
        this.xPos = xPos;
        this.yPos = yPos;
        this.orientation = normalizedVector(orientation);
        this.screenDim = Canvas.getInstance().getScreenDimentions();
        this.bullet = new Picture(xPos, yPos, "Bullets/red_bullet.png");

        super.setPicture(bullet);

        this.collisionRadius = Math.min(bullet.getHeight(), bullet.getWidth()) / 2.1;
        bullet.rotate(getRotationFromVector(orientation, bullet, Math.PI / 2));
        draw();
    }

    @Override
    public boolean move() {

        if (bullet.getX() < 0 - bullet.getWidth() || bullet.getX() > screenDim[0] || bullet.getY() < 0 || bullet.getY() > screenDim[1]) {
            bullet.delete();
            return true;
        }

        bullet.translate(orientation[0] * super.getSpeed(), orientation[1] * super.getSpeed());
        updatePosition();
        return false;
    }

    @Override
    public void move(double[] vector) {

    }

    @Override
    public void move(boolean[] directions, double[] orientation) {

    }

    @Override
    public double[] getPosition() {
        double[] pos = {xPos, yPos};
        return pos;
    }

    @Override
    public void updatePosition() {
        xPos = bullet.getWidth() / 2 + bullet.getX();
        yPos = bullet.getHeight() / 2 + bullet.getY();

    }

    public void delete(){
        bullet.delete();
    }
    @Override
    public void draw() {
        bullet.draw();
    }


    @Override
    public String toString() {
        return "Bullet{ damage: " + getDamage() + " speed: " + getSpeed() + " }";
    }
}
