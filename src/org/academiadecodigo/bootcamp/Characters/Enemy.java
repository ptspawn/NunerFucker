package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Enemy extends Character implements Drawable, Movable, Shootable {

    private double xPos;
    private double yPos;
    private Picture enemy;
    private double[] screenDim;

    public Enemy() {
        super(CharactersType.ENEMY.getHealth(), CharactersType.ENEMY.getSpeed());
        this.xPos=xPos;
        this.yPos=yPos;
        this.screenDim = Canvas.getInstance().getScreenDimentions();
        this.enemy = new Picture(xPos, yPos,"Bullets/Bullet.png");
        draw();


    }

    //getters
    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }



    @Override
    public void getHit(int damage) {

    }

    @Override
    public void die() {

    }

    @Override
    public void move(double[] vector) {
        while (true) {
           /* if (enemy.getX() < 0 - enemy.getWidth() || enemy.getX() > screenDim[0] || enemy.getY() < 0 || enemy.getY() > screenDim[1]) {
                enemy.delete();
                System.out.println("stop at " + enemy.getX() + " " + enemy.getY());
                return;
            }*/

            System.out.println("moving");
            enemy.translate(vector[0] * super.getSpeed(), vector[1] * super.getSpeed());
        }
    }

    @Override
    public void draw() {

    }

    @Override
    public void setDirection(double[] vector) {

    }

    @Override
    public void preLoadGraphics() {

    }

    @Override
    public void move(boolean[] directions, double[] orientation) {
    }

    @Override
    public String toString() {
        return "Enemy{ health: " + getHealth() + " speed: " + getSpeed() + " }";
    }
}
