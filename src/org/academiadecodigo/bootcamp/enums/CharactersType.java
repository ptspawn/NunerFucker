package org.academiadecodigo.bootcamp.enums;


/**
 * Created by codecadet on 02/06/2018.
 */
public enum CharactersType {
    PLAYER(150, 10, 0, 0, 0, 0, "resources/avatar/nun_with_gun.png"),
    ENEMY(50, 5, 30, 25, 2, 100, "resources/Characters/Enemies/purpleEnemy.png"),
    BUG(30, 4, 20, 25, 2, 50, "resources/Characters/Enemies/bug.png"),
    SPIDER(60, 4, 25, 35, 10, 200, "resources/Characters/Enemies/spider.png"),
    HUMAN(80, 5, 20, 30, 20, 30, "resources/Characters/Enemies/human.png"),
    SPACESHIP(100, 9, 10, 10, 30, 6, "resources/Characters/Enemies/spaceship.png"),
    ZOMBIE(110, 5, 40, 55, 10, 100, "resources/Characters/Enemies/whiteEnemy.png"),
    ZOMBIEBOSS(350, 3, 50, 10, 20, 10, "resources/Characters/Enemies/whiteBoss.png");


    private int health;
    private int speed;
    private String path;
    private double damage;
    private int hitRate;
    private int directionRate;
    private int directionGap;

    CharactersType(int health, int speed, int damage, int hitRate, int directionRate, int directionGap, String path) {
        this.health = health;
        this.speed = speed;
        this.path = path;
        this.damage = damage;
        this.hitRate = hitRate;
        this.directionRate = directionRate;
        this.directionGap = directionGap;

    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public double getDamage() {
        return damage;
    }

    public int getHitRate() {
        return hitRate;
    }

    public String getPath() {
        return path;
    }

    public int getDirectionRate() {
        return directionRate;
    }

    public int getDirectionGap() {
        return directionGap;
    }
}
