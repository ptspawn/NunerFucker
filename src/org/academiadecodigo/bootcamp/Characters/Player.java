package org.academiadecodigo.bootcamp.Characters;


import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.bootcamp.GameEngine.factories.ProjectileFactory;
import org.academiadecodigo.bootcamp.enums.*;
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
    private boolean tookDamage;

    public Player(String name, double xPos, double yPos) {
        super(CharactersType.PLAYER.getHealth(), CharactersType.PLAYER.getSpeed(), CharactersType.PLAYER);
        this.name = name;

        position = new double[2];

        avatar = new Picture(xPos, yPos, "resources/avatar/nun_with_gun.png");

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

    public boolean tookDamage() {
        return tookDamage;
    }

    public Projectile shoot(double[] whereTo) {
        if (shotRateCounter++ >= ProjectileType.BULLET.getFireRate() / Game.FIRE_RATE_MODIFIER) {

            shotRateCounter = 0;

            if (Game.BULLETTIME == 1) {
                SoundType.GUN.playSound();
            } else {
                SoundType.BULLETTIME.playSound();
            }
            return ProjectileFactory.shoot(ProjectileType.BULLET, position, getVector(position, whereTo));

        }

        return null;

    }

    public void delete() {
        avatar.delete();
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

        tookDamage = false;

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

            avatar.translate(getSpeed() * vector[0] / (Game.BULLETTIME * 0.8), getSpeed() * vector[1] / (Game.BULLETTIME * 0.8));
        }
        updatePosition();
    }

    public void catchPowerup(PowerUpType powerUp) {
        System.out.println("Caught " + powerUp.getValue());
        switch (powerUp) {
            case GUN:
                PlayerVoiceType.KILL.playSound();
                Game.FIRE_RATE_MODIFIER = 2;
                break;
            case TIME:
                Game.BULLETTIME = 2;
                break;
            case WEED:
                break;
            case HEALTH:
                PlayerVoiceType.MUCHBETTER.playSound();
                super.addLife(powerUp.getValue());
                break;
        }

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
        if (dmg != 0 && !isDead()) {
            PlayerVoiceType.values()[(int) (Math.random() * 3) + 4].playSound();
            tookDamage = true;
            super.getHit(dmg);
        }
    }
}
