package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.GameEngine.factories.PowerUpFactory;
import org.academiadecodigo.bootcamp.Interfaces.*;
import org.academiadecodigo.bootcamp.enums.*;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Character implements Movable, Shootable, Drawable, Collidable {

    private DirectionType directionType;
    private int health;
    private int speed;
    private boolean isDead = false;
    private Picture avatar;
    private CharactersType type;


    public Character(int health, int speed, CharactersType type) {
        this.health = health;
        this.speed = speed;
        this.type = type;

    }

    public void setDirectionType(DirectionType directionType) {

        this.directionType = directionType;

    }

    public void setAvatar(Picture avatar) {
        this.avatar = avatar;
    }

    public void getHit(int dmg) {

        if (isDead) {
            return;
        }

        if ((health -= dmg) <= 0) {

            die();

        }

    }

    public void die() {

        String path;
        boolean voiceOver = false;
        boolean drop=false;

        if (Math.random() * 10 <= 3) {
            voiceOver = true;
        }

        if (Math.random()*10<=2){
            drop=true;
        }

        switch (type) {
            case PLAYER:
                PlayerVoiceType.DAMN.playSound();
                path = "resources/avatar/nun_dead_blood.png";
                break;

            case ZOMBIEBOSS:
                if (voiceOver) {
                    PlayerVoiceType.values()[(int) (Math.random() * (PlayerVoiceType.values().length - 7)) + 7].playSound();
                }
                path = BloodType.values()[BloodType.values().length - 1].getPath();
                Game.SCORE += type.getHealth();
                if (drop) {
                    Game.powerUps.add(PowerUpFactory.getNewPowerUp(getPosition()));
                    System.out.println("powerups count" + Game.powerUps.size());
                }
                break;

            default:
                if (voiceOver) {
                    PlayerVoiceType.values()[(int) (Math.random() * (PlayerVoiceType.values().length - 7)) + 7].playSound();
                }
                path = BloodType.values()[(int) (Math.random() * (BloodType.values().length - 1))].getPath();
                Game.SCORE += type.getHealth();
                if (drop) {
                    Game.powerUps.add(PowerUpFactory.getNewPowerUp(getPosition()));
                    System.out.println("powerups count" + Game.powerUps.size());
                }
                break;
        }

        avatar.load(path);
        isDead = true;
    }

    @Override
    public boolean isDead(){
        return isDead;
    }

    public void addLife(int howMuch){
        health+=howMuch;
        if (health>100){health=100;}
    }

    public void move(double[] vector) {

    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }


}
