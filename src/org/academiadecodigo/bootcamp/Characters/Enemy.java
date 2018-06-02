package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.CharactersType;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.bootcamp.Interfaces.Shootable;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Enemy extends Character implements Drawable, Movable, Shootable {

    public Enemy() {
        super(CharactersType.ENEMY.getHealth(), CharactersType.ENEMY.getSpeed());
    }

    @Override
    public void getHit(int damage) {

    }

    @Override
    public void die() {

    }

    @Override
    public void move(boolean[] directions) {

    }

    @Override
    public void move(double[] vector){

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
    public String toString() {
        return "Enemy{ health: " + getHealth() + " speed: " + getSpeed() + " }";
    }
}
