package org.academiadecodigo.bootcamp.Characters;


import org.academiadecodigo.bootcamp.Interfaces.CharactersType;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.Interfaces.Movable;
import org.academiadecodigo.bootcamp.Interfaces.Shootable;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Player extends Character implements Drawable, Movable, Shootable {

    String name;


    public Player(String name){
        super(CharactersType.PLAYER.getHealth(), CharactersType.PLAYER.getSpeed());
        this.name = name;
    }


    public void die(){

    }

    public void setDirection(double[] vector){

    }

    public void draw(){


    }

    public void preLoadGraphics(){

    }

    public void shoot(){

    }


    @Override
    public void move(){
    }

    public void getHit(int dmg){
    }

    @Override
    public String toString() {
        return "Player{ name: " + name + " health: " + getHealth() + " speed: " + getSpeed() + "}";
    }
}
