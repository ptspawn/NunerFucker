package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.normalizedVector;

/**
 * Created by codecadet on 02/06/2018.
 */
public class pTest extends Character {

    String name;
    Picture avatar;

    public pTest(String name, double xPos, double yPos) {
        super(100, 1);



        this.name = name;

        setHealth(100);

        setSpeed(5);

        avatar = new Picture(xPos, yPos, "Characters/player.png");

        draw();

    }

    public void shoot(){

        System.out.println("Shooting!!");

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
    public void move(boolean[] moveDirections) {

        double[] vector = {0,0};   //horizontal,vertical

        if (moveDirections[0]){
            vector[1]=-1;
        }
        if (moveDirections[1]){
            vector[0]=1;
        }
        if (moveDirections[2]){
            vector[1]=1;
        }
        if (moveDirections[3]){
            vector[0]=-1;
        }

        vector=normalizedVector(vector);

        avatar.translate(getSpeed()*vector[0],getSpeed()*vector[1]);


    }

    public void getHit(int dmg) {


    }
}
