package org.academiadecodigo.bootcamp.Characters;


import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;


import java.awt.image.BufferedImage;

import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.normalizedVector;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Player extends Character implements Drawable, Movable, Shootable, Rotatable {

    private String name;
    private boolean isDead;
    private Picture avatar;
    private BufferedImage playerAv;
    private double collisionRadius;

    private double[] position;

    public Player(String name, double xPos, double yPos) {
        super(CharactersType.PLAYER.getHealth(), CharactersType.PLAYER.getSpeed());
        this.name = name;

        position=new double[2];
        position[0]=xPos;
        position[1]=yPos;

        avatar = new Picture(xPos, yPos, "Characters/player.png");
        collisionRadius=(avatar.getHeight()+avatar.getWidth())/4;

        //playerAv=new BufferedImage()

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
    public void rotate() {
        /*
// The required drawing location
        int drawLocationX = 300;
        int drawLocationY = 300;

// Rotation information
        double rotationRequired = Math.toRadians (45);
        double locationX = avatar.getWidth() / 2;
        double locationY = avatar.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        op.filter(avatar,null);

// Drawing the rotated image at the required drawing locations
        Graphics2D.drawImage(op.filter(avatar, null), drawLocationX, drawLocationY, null);


*/
    }

    @Override
    public void move(boolean[] moveDirections, double[] orientation) {

        double orientationVector[]={orientation[0]-position[0],orientation[1]-position[1]};

        double angleToRotate=Math.atan(orientationVector[1]/orientationVector[0]);

        avatar.rotate(angleToRotate-Math.PI/2);

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

    }

    public void getHit(int dmg) {
    }

    public double[] getPosition(){
        return position;
    }

    @Override
    public String toString() {
        return "Player{ name: " + name + " health: " + getHealth() + " speed: " + getSpeed() + "}";
    }
}
