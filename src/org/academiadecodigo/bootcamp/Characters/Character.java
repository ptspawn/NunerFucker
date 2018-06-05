package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.DirectionType;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.bootcamp.Interfaces.Shootable;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Character implements Movable, Shootable, Drawable{

    private DirectionType directionType;
    private int health;
    private int speed;


    public Character(int health, int speed) {
        this.health = health;
        this.speed = speed;

    }

    public void setDirectionType(DirectionType directionType){

        this.directionType = directionType;

    }

    public void move(double[] vector){

    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
