package org.academiadecodigo.bootcamp.Projectiles;

import org.academiadecodigo.bootcamp.Interfaces.ProjectileType;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;


/**
 * Created by codecadet on 02/06/2018.
 */
public class Bullet extends Projectile implements Drawable, Movable {

    private double xPos;
    private double yPos;
    private Picture bullet;
    private double[] screenDim;

    public Bullet(double xPos, double yPos) {
        super(ProjectileType.BULLET.getDamage(), ProjectileType.BULLET.getSpeed());
        this.xPos = xPos;
        this.yPos = yPos;
        this.screenDim = Canvas.getInstance().getScreenDimentions();
        this.bullet = new Picture(xPos, yPos,"Bullets/Bullet.png");
        draw();
    }

    @Override
    public void move(double[] vector) throws InterruptedException {

        while (true) {
            if (bullet.getX() < 0 || bullet.getX() > screenDim[0] || bullet.getY() < 0 || bullet.getY() > screenDim[1]) {
                bullet.delete();
                System.out.println("stop at " + bullet.getX() + " " + bullet.getY());
                return;
            }
            System.out.println("moving");
            bullet.translate(vector[0] * super.getSpeed(), vector[1] * super.getSpeed());
            Thread.sleep(20);
        }
    }


    @Override
    public void move(boolean[] directions, double[] orientation) {

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
