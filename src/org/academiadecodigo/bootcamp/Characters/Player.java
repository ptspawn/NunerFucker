package org.academiadecodigo.bootcamp.Characters;


import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.normalizedVector;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Player extends Character implements Drawable, Movable, Shootable, Rotatable {

    private String name;
    private boolean isDead;
    private Picture avatar;

    public Player(String name, double xPos, double yPos){
        super(CharactersType.PLAYER.getHealth(), CharactersType.PLAYER.getSpeed());
        this.name = name;

        avatar = new Picture(xPos, yPos, "Characters/player.png");

        draw();

    }


    public void die(){

    }

    public void setDirection(double[] vector){

    }

    public void draw(){

        avatar.draw();

    }

    public void preLoadGraphics(){

    }

    public void shoot(){
        System.out.println("i'm Shooting");

    }

    public boolean isDead() {
        return isDead;
    }

    @Override
    public void rotate() {

    }

    @Override
    public void move(boolean[] moveDirections){
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

    public void getHit(int dmg){
    }

    @Override
    public String toString() {
        return "Player{ name: " + name + " health: " + getHealth() + " speed: " + getSpeed() + "}";
    }
}
