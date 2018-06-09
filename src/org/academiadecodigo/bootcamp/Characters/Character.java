package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.bootcamp.enums.DirectionType;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Character implements Movable, Shootable, Drawable, Collidable{

    private DirectionType directionType;
    private int health;
    private int speed;
    private boolean isDead=false;


    public Character(int health, int speed) {
        this.health = health;
        this.speed = speed;

    }

    public void setDirectionType(DirectionType directionType){

        this.directionType = directionType;

    }

    public void getHit(int dmg){

        if (isDead){return;}

        System.out.println(this.toString() + " has been hit for " + dmg);

        if ((health-=dmg)<=0){

            die();

        }

    }

    public void die(){

        isDead=true;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    public void move(double[] vector){

    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }


}
