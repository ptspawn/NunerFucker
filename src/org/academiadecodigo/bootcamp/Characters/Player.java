package org.academiadecodigo.bootcamp.Characters;


import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;


import java.awt.image.BufferedImage;

import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.getRotationFromVector;
import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.normalizedVector;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Player extends Character implements Drawable, Movable, Shootable {

    private String name;
    private boolean isDead;
    private Picture avatar;
    private BufferedImage playerAv;
    private double collisionRadius;

    private double[] position;

    public Player(String name, double xPos, double yPos) {
        super(CharactersType.PLAYER.getHealth(), CharactersType.PLAYER.getSpeed());
        this.name = name;

        position = new double[2];

        avatar = new Picture(xPos, yPos, "Characters/player.png");
        collisionRadius = (avatar.getHeight() + avatar.getWidth()) / 4;

        draw();

    }


    public void die() {

    }

    public void setDirection(double[] vector) {

    }

    public void draw() {

        avatar.draw();

    }

    public double getCollisionRadius() {
        return collisionRadius;
    }

    public void preLoadGraphics() {

    }

    public void shoot(double[] whereTo) {
        System.out.println("i'm Shooting");

    }

    public boolean isDead() {
        return isDead;
    }


    @Override
    public void move() {

    }

    @Override
    public void move(boolean[] moveDirections, double[] orientation) {

        avatar.rotate(getRotationFromVector(orientation,avatar,Math.PI/2));

        double[] vector = {0, 0};   //horizontal,vertical

        if (moveDirections[0]) {
            vector[1] = -1;
        }
        if (moveDirections[1]) {
            vector[0] = 1;
        }
        if (moveDirections[2]) {
            vector[1] = 1;
        }
        if (moveDirections[3]) {
            vector[0] = -1;
        }

        vector = normalizedVector(vector);

        avatar.translate(getSpeed() * vector[0], getSpeed() * vector[1]);
        updatePosition();

    }

    public void getHit(int dmg) {
    }

    private void updatePosition() {
        position[0] = avatar.getWidth() + avatar.getX();
        position[1] = avatar.getHeight() + avatar.getY();
        System.out.println("Player: x"+ position[0]+ " y" + position[1]);
    }

    public double[] getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{ name: " + name + " health: " + getHealth() + " speed: " + getSpeed() + "}";
    }
}
