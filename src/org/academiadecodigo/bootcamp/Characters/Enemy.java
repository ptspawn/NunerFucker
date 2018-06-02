package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.CharactersType;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Enemy extends Character {

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
