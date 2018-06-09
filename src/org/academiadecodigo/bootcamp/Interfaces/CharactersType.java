package org.academiadecodigo.bootcamp.Interfaces;

import java.net.URL;

/**
 * Created by codecadet on 02/06/2018.
 */
public enum CharactersType {
    PLAYER(100, 10,"Characters/Enemies/human.png"),
    ENEMY(50, 3,"Characters/Enemies/purpleEnemy.png"),
    BUG(30,3,"Characters/Enemies/bug.png"),
    SPIDER(60,3,"Characters/Enemies/bug.png"),
    HUMAN(80,4,"Characters/Enemies/human.png"),
    SPACESHIP(100,5,"Characters/Enemies/spaceship.png"),
    ZOMBIE(80,2,"Characters/Enemies/whiteEnemy.png"),
    ZOMBIEBOSS(200,3,"Characters/Enemies/whiteBoss.png");


    private int health;
    private int speed;
    private String path;
    private double collisionRadius;

    CharactersType(int health, int speed,String path) {
        this.health = health;
        this.speed = speed;
        this.path=path;

    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public String getPath() {
        return path;
    }
}
