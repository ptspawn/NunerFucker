package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.*;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Character implements Movable, Shootable, Drawable, Collidable{

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

    public void getHit(int dmg){

        System.out.println(this.toString() + " has been hit for " + dmg);

        if ((health-=dmg)<=0){

            die();

        }

    }

    public void die(){

        System.out.println(this.toString() + " is dead");
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
