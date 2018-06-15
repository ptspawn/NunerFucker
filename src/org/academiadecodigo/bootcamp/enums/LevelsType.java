package org.academiadecodigo.bootcamp.enums;

/**
 * Created by codecadet on 08/06/2018.
 */
public enum LevelsType {

    VIRGIN(new int[][]{{500, 15, 10, 0, 0, 0, 0}, {500, 10, 10, 15, 0, 0, 0, 0},
            {1000, 0, 20, 15, 20, 0, 0, 0}, {1500, 0, 0, 0, 30, 25, 10, 0}, {0, 0, 0, 0, 20, 20, 35, 1}}),

    EXPERIENT(new int[][]{{500, 15, 10, 0, 0, 0, 0}, {500, 10, 10, 15, 0, 0, 0, 0},
            {1000, 0, 20, 15, 20, 0, 0, 0}, {1500, 0, 0, 0, 30, 40, 25, 1}, {0, 0, 0, 10, 35, 30, 50, 2}}),

    USED(new int[][]{{500, 15, 10, 0, 0, 0, 0}, {500, 10, 10, 15, 0, 0, 0, 0},
            {1000, 0, 20, 15, 20, 0, 0, 0}, {1500, 0, 0, 0, 30, 25, 10, 0}, {0, 0, 0, 0, 20, 20, 35, 1}}),

    SLUT(new int[][]{{500, 15, 10, 0, 0, 0, 0}, {500, 10, 10, 15, 0, 0, 0, 0},
            {1000, 0, 20, 15, 20, 0, 0, 0}, {1500, 0, 0, 0, 30, 25, 10, 0}, {0, 0, 0, 0, 20, 20, 35, 1}}),

    XXX(new int[][]{{500, 15, 10, 0, 0, 0, 0}, {500, 10, 10, 15, 0, 0, 0, 0},
            {1000, 0, 20, 15, 20, 0, 0, 0}, {1500, 0, 0, 0, 30, 25, 10, 0}, {0, 0, 0, 0, 20, 20, 35, 1}});


    private int enemyQty;
    private int bugsQty;
    private int spiderQty;
    private int humanQty;
    private int spaceshipQty;
    private int zombieQty;
    private int zombieBossQty;

    private int enemyQuant;

    LevelsType(int[][] levelDefs) {

        this.enemyQty = enemyQty;
        this.bugsQty = bugsQty;
        this.spiderQty = spiderQty;
        this.humanQty = humanQty;
        this.spaceshipQty = spaceshipQty;
        this.zombieQty = zombieQty;
        this.zombieBossQty = zombieBossQty;
    }

    public int[] getEnemyQuantity() {

        int[] result = {enemyQty, bugsQty, spiderQty, humanQty, spaceshipQty, zombieQty, zombieBossQty};
        return result;

    }

    public int getEnemyTotal() {
        return enemyQty + bugsQty + spiderQty + humanQty + spaceshipQty + zombieQty + zombieBossQty;
    }

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

}


