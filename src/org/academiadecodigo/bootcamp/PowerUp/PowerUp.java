package org.academiadecodigo.bootcamp.PowerUp;

import org.academiadecodigo.bootcamp.Interfaces.Collidable;
import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.bootcamp.enums.PowerUpType;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

public abstract class PowerUp implements Collidable, Drawable {

    private Picture powerUp;
    private PowerUpType type;
    private boolean isCaught = false;
    private int value;
    private double collisionRadius;

    public PowerUp(PowerUpType type, double[] position){
        this.type = type;
        this.powerUp = new Picture(position[0],position[1],type.getPath());
        value = type.getValue();
        powerUp.draw();
    }

  /*  public void setPowerUp(String pictureFile, double xPos, double yPos){
        this.powerUp = new Picture(xPos, yPos, pictureFile);
    }*/

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
}
