package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.Direction;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.bootcamp.Interfaces.Shootable;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Character implements Movable, Shootable, Drawable{

    private Direction direction;
    private int health;
    private int speed;


    public void setDirection(Direction direction){

        this.direction=direction;

    }

    public void move(){

    }

    public Direction getDirection() {
        return direction;
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
