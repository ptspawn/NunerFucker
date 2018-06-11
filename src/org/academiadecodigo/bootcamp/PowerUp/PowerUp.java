package org.academiadecodigo.bootcamp.PowerUp;

import org.academiadecodigo.bootcamp.Interfaces.Collidable;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.enums.PowerUpType;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

public abstract class PowerUp implements Collidable, Drawable {

    private Picture powerUp;
    private PowerUpType type;
    private boolean isCaught = false;
    private int value;
    private double collisionRadius;
    private double[] position;

    public PowerUp(PowerUpType type, double[] position){
        this.type = type;
        this.powerUp = new Picture(position[0],position[1],type.getPath());
        this.powerUp.translate(-powerUp.getWidth()/2,-powerUp.getHeight()/2);

        this.position=new double[2];
        this.position[0]=position[0]-powerUp.getWidth()/2;
        this.position[1]=position[1]-powerUp.getHeight()/2;

        collisionRadius = (powerUp.getHeight() + powerUp.getWidth()) / 4;
        value = type.getValue();
        powerUp.draw();
    }

    @Override
    public void draw() {
        powerUp.draw();
    }

    @Override
    public void preLoadGraphics() {

    }

    public Picture getPowerUp() {
        return powerUp;
    }

    public void setCaught(){
        isCaught = true;
        powerUp.delete();
    }

    @Override
    public int getCollisionRadius() {
        return (int)collisionRadius;
    }

    public int getValue() {
        return value;
    }

    public PowerUpType getType() {
        return type;
    }

    public double[] getPosition(){

        return position;
    }
}
