package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 02/06/2018.
 */
public class pTest extends Character {

    String name;
    Picture avatar;

    public pTest(String name, double xPos, double yPos) {

        this.name = name;

        setHealth(100);

        setSpeed(5);

        avatar = new Picture(xPos, yPos, "Characters/player.png");

        draw();

    }

    public void shoot(){

    }

    public void die() {

    }

    public void setDirection(double[] vector) {

    }

    public void draw() {

        avatar.draw();

    }

    public void preLoadGraphics() {

    }


    @Override
    public void move() {
    }

    public void getHit(int dmg) {


    }
}
