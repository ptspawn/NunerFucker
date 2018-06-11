package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.bootcamp.enums.CharactersType;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.*;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Enemy extends Character {

    private double xPos;
    private double yPos;
    private Picture enemy;
    private CharactersType type;
    private double collisionRadius;
    private double damage;

    private int hitCounter;
    private int directionCounter;
    private double[] currentDirection;

    public Enemy(double[] statingPosition, CharactersType type) {
        super(type.getHealth(), type.getSpeed(),type);
        this.xPos = statingPosition[0];
        this.yPos = statingPosition[1];
        this.type = type;
        this.enemy = new Picture(xPos, yPos, type.getPath());

        super.setAvatar(enemy);

        damage=type.getDamage();

        hitCounter=(int)(Math.random()*type.getHitRate());
        directionCounter=(int)(Math.random()*type.getDirectionRate());


        double[] originalDir={Game.SCREENDIMENTIONS[0]/2,Game.SCREENDIMENTIONS[1]/2};
        currentDirection=normalizedVector(getVector(getPosition(),originalDir));

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

    public void hide(){
        enemy.delete();
    }

    public int getDamage() {

        if (super.isDead()){return 0;}

        int damage=0;

        if (hitCounter++==type.getHitRate()){
            hitCounter=0;
            damage=(int)this.damage;
        }

        return damage;
    }

    @Override
    public void move(double[] vector) {

        if (!super.isDead()) {



            if (directionCounter++==type.getDirectionRate()){
                directionCounter=0;

                vector=getVector(getPosition(),vector);

                //vector = normalizedVector(vector);
                currentDirection=getDeviatedNormalizedVector(vector,type);

            }

            enemy.rotate(getRotationFromVector(currentDirection, enemy, Math.PI / 2));
            enemy.translate(currentDirection[0] * super.getSpeed(), currentDirection[1] * super.getSpeed());

            updatePosition();
        }
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
    public int getCollisionRadius() {
        return (int)collisionRadius;
    }

    @Override
    public boolean move() {
        return false;
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
