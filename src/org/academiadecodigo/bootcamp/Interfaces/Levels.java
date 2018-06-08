package org.academiadecodigo.bootcamp.Interfaces;

/**
 * Created by codecadet on 08/06/2018.
 */
public enum Levels{

    VIRGIN(30, 10, 10, 10,10, 10, 1),
    EXPERIENT(40,15, 15, 15,15,15 , 1),
    USED (50,20, 20, 20,20,20, 1 ),
    XXX (60, 25, 25, 25,25,25, 1),
    SLUT (80, 30, 30, 30,30,30, 1);


    private int enemyQty;
    private int bugsQty;
    private int spiderQty;
    private int humanQty;
    private int spaceshipQty;
    private int zombieQty;
    private int zombieBossQty;


    //purple Enemy
    public int getEnemyQty() {
        return enemyQty;
    }

    //bugs
    public int getBugsQty() {
        return bugsQty;
    }
    //Spider
    public int getSpiderQty() {
        return spiderQty;
    }
    public int getHumanQty() {
        return humanQty;
    }
    public int getSpaceshipQty() {
        return spaceshipQty;
    }
    //Zombie
    public int getZombieQty() {
        return zombieQty;
    }
    //ZombieBoss
    public int getZombieBossQty() {
        return zombieBossQty;
    }

    // Constructor
    Levels(int enemyQty, int bugsQty, int spiderQty, int humanQty,int spaceshipQty , int zombieQty, int zombieBossQty) {

        this.enemyQty=enemyQty;
        this.bugsQty=bugsQty;
        this.spiderQty=spiderQty;
        this.humanQty=humanQty;
        this.spaceshipQty=spaceshipQty;
        this.zombieQty=zombieQty;
        this.zombieBossQty=zombieBossQty;
    }

}


