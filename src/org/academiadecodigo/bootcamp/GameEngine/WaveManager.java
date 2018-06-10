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
    private long elapsedTime;
    private LinkedList<Enemy> npcList;
    private final int MAX_PER_WAVE = 20;
    private final int ENEMIES_BEFORE_NEXT = 5;
    private int waveCount;
    private int liveEnemies;
    private Player player;


    public WaveManager(LevelsType level, LinkedList<Enemy> list, Player player) {

        currentLevel = level;
        waveStart = System.nanoTime();
        npcList = list;
        waveCount = 0;
        this.player = player;
    }

    public int moveEnemies() {

        Enemy enemy;
        liveEnemies = 0;

        double collisionRadius;

        for (int i = 0; i < Math.min((MAX_PER_WAVE * (1 + waveCount)), npcList.size()); i++) {

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

        if (liveEnemies <= ENEMIES_BEFORE_NEXT) {

            //System.out.println("Live enemies:" + liveEnemies);

            waveCount++;
            //System.out.println(" now entering " + waveCount);
        }

        return liveEnemies;
    }


}
