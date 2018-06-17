package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.enums.LevelsType;

import java.util.LinkedList;

/**
 * Created by codecadet on 09/06/2018.
 */
public class WaveManager {

    private LevelsType currentLevel;
    private long waveStart;
    private int referenceCycle;
    private LinkedList<Enemy> npcList;
    private final int ENEMIES_BEFORE_NEXT = 5;
    private int waveCount;
    private int liveEnemies;
    private Player player;


    public WaveManager(LevelsType level, LinkedList<Enemy> list, Player player, int currentCyle) {

        currentLevel = level;
        npcList = list;
        waveCount = 0;
        this.player = player;
    }

    public int moveEnemies(int cycleCount) {

        Enemy enemy;
        liveEnemies = 0;

        double collisionRadius;

        for (int i = 0; i < currentLevel.getEnemyCountbyWave(waveCount); i++) {

            enemy = npcList.get(i);

            if (!enemy.isDead()) {

                enemy.move(player.getPosition());

                liveEnemies++;

                collisionRadius = player.getCollisionRadius() + enemy.getCollisionRadius();

                if (Collider.checkCollision(player.getPosition(), enemy.getPosition(), collisionRadius)) {

                    player.getHit(enemy.getDamage());
                }

            }

        }

        if (liveEnemies <= ENEMIES_BEFORE_NEXT || cycleCount>currentLevel.getCycleLimitByWave(waveCount)) {

            //System.out.println("Live enemies:" + liveEnemies);

            waveCount++;
            //System.out.println(" now entering " + waveCount);
        }
        //System.out.println(liveEnemies);
        return liveEnemies;
    }


}
