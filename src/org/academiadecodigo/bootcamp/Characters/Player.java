package org.academiadecodigo.bootcamp.Characters;


import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.bootcamp.GameEngine.factories.ProjectileFactory;
import org.academiadecodigo.bootcamp.enums.CharactersType;
import org.academiadecodigo.bootcamp.enums.PlayerVoiceType;
import org.academiadecodigo.bootcamp.enums.ProjectileType;
import org.academiadecodigo.bootcamp.enums.SoundType;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;


import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.getRotationFromMousePos;
import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.getVector;
import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.normalizedVector;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Player extends Character {

    private String name;
    private Picture avatar;
    private double collisionRadius;

    private int shotRateCounter = 0;

    private double[] position;

    public Player(String name, double xPos, double yPos) {
        super(CharactersType.PLAYER.getHealth(), CharactersType.PLAYER.getSpeed(),CharactersType.PLAYER);
        this.name = name;

        position = new double[2];

        avatar = new Picture(xPos, yPos, "avatar/nun_char.png");

        super.setAvatar(avatar);

        collisionRadius = Math.min(avatar.getHeight(), avatar.getWidth()) / 2.1;

        draw();

    }


    public void setDirection(double[] vector) {

    }

    public void draw() {

        avatar.draw();

    }

    @Override
    public int getCollisionRadius() {
        return (int) collisionRadius;
    }

    public void preLoadGraphics() {

    }

    public Projectile shoot(double[] whereTo) {
        if (shotRateCounter++ == ProjectileType.BULLET.getFireRate()) {

            shotRateCounter = 0;
            SoundType.GUN.playSound();
            return ProjectileFactory.shoot(ProjectileType.BULLET, position, getVector(position, whereTo));

        }

        return null;

    }


    @Override
    public boolean move() {
        return false;
    }

    @Override
    public void move(boolean[] moveDirections, double[] orientation) {

        if (super.isDead()) {
            return;
        }

        avatar.rotate(getRotationFromMousePos(orientation, avatar, Math.PI / 2));

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

        if (checkBounds(vector)) {

            avatar.translate(getSpeed() * vector[0], getSpeed() * vector[1]);
        }
        updatePosition();
    }


    public void updatePosition() {
        position[0] = avatar.getWidth() / 2 + avatar.getX();
        position[1] = avatar.getHeight() / 2 + avatar.getY();
    }

    public double[] getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{ name: " + name + " health: " + getHealth() + " speed: " + getSpeed() + "}";
    }

    private boolean checkBounds(double[] movementVector) {

        double[] futurePos = {position[0] + movementVector[0] * getSpeed(), position[1] + movementVector[1] * getSpeed()};

        if (futurePos[0] <= 0 || futurePos[0] >= Game.SCREENDIMENTIONS[0]
                || futurePos[1] <= 0 || futurePos[1] >= Game.SCREENDIMENTIONS[1]) {
            return false;
        }

        return true;
    }

    @Override
    public void getHit(int dmg) {
        if (dmg!=0 && !isDead()) {
            PlayerVoiceType.values()[(int) (Math.random() * 3) + 4].playSound();
            super.getHit(dmg);
        }
    }
}
