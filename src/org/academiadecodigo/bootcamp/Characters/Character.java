package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.bootcamp.enums.DirectionType;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Character implements Movable, Shootable, Drawable, Collidable{

    private DirectionType directionType;
    private int health;
    private int speed;
    private boolean isDead=false;
    private Picture avatar;


    public Character(int health, int speed) {
        this.health = health;
        this.speed = speed;

    }

    public void setDirectionType(DirectionType directionType){

        this.directionType = directionType;

    }

    public void setAvatar(Picture avatar) {
        this.avatar = avatar;
    }

    public void getHit(int dmg){

        if (isDead){return;}

        if ((health-=dmg)<=0){

            die();

        }

        System.out.println(this.toString() + " has been hit for " + dmg);

    }

    public void die(){

        avatar.load();

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
