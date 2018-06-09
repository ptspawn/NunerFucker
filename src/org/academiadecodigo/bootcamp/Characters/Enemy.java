package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.bootcamp.enums.CharactersType;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.*;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Enemy extends Character implements Drawable, Movable, Shootable {

    private double xPos;
    private double yPos;
    private Picture enemy;
    private CharactersType type;
    private double collisionRadius;
    private double damage;

    private int hitCounter;

    public Enemy(double[] statingPosition, CharactersType type) {
        super(type.getHealth(), type.getSpeed());
        this.xPos = statingPosition[0];
        this.yPos = statingPosition[1];
        this.type = type;
        this.enemy = new Picture(xPos, yPos, type.getPath());

        damage=type.getDamage();
        hitCounter=type.getHitRate();

        collisionRadius=Math.min(enemy.getHeight(),enemy.getWidth())/2.1;
        draw();


    }

    //getters
    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public int getDamage() {

        int damage=0;

        if (hitCounter++==type.getHitRate()){
            hitCounter=0;
            damage=(int)this.damage;
        }

        return damage;
    }

    @Override
    public void getHit(int damage) {

    }

    @Override
    public void die() {

    }

    @Override
    public void move(double[] vector) {
        //System.out.println("Enemy: vX- " + vector[0] + " vY-"+vector[1]);

        vector = normalizedVector(getVector(getPosition(), vector));
        //System.out.println("EnemyN: vX- " + vector[0] + " vY-"+vector[1]);
        enemy.rotate(getRotationFromVector(vector, enemy, Math.PI / 2));
        enemy.translate(vector[0] * super.getSpeed(), vector[1] * super.getSpeed());

        updatePosition();
    }

    public double[] getPosition() {
        double pos[] = {xPos, yPos};
        return pos;
    }

    public void updatePosition() {
        xPos = enemy.getX() + enemy.getWidth() / 2;
        yPos = enemy.getY() + enemy.getHeight() / 2;
    }

    @Override
    public double getCollisionRadius() {
        return collisionRadius;
    }

    @Override
    public void move() {

    }

    @Override
    public void draw() {
        enemy.draw();
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
