package org.academiadecodigo.bootcamp.enums;


/**
 * Created by codecadet on 02/06/2018.
 */
public enum CharactersType {
    PLAYER(1000, 10, 10, 0, 0, 0, "Resources/Characters/Enemies/human.png"),
    ENEMY(50, 3, 30, 50, 2, 100, "Resources/Characters/Enemies/purpleEnemy.png"),
    BUG(30, 3, 20, 40, 2, 50, "Resources/Characters/Enemies/bug.png"),
    SPIDER(60, 3, 25, 35, 10, 200, "Resources/Characters/Enemies/spider.png"),
    HUMAN(80, 4, 20, 40, 20, 30, "Resources/Characters/Enemies/human.png"),
    SPACESHIP(100, 5, 10, 10, 30, 6, "Resources/Characters/Enemies/spaceship.png"),
    ZOMBIE(80, 2, 40, 55, 10, 100, "Resources/Characters/Enemies/whiteEnemy.png"),
    ZOMBIEBOSS(200, 3, 50, 10, 20, 10, "Resources/Characters/Enemies/whiteBoss.png");


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
