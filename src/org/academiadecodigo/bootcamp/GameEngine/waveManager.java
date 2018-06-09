package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.enums.LevelsType;

import java.util.LinkedList;

/**
 * Created by codecadet on 09/06/2018.
 */
public class waveManager {

    private LevelsType currentLevel;
    private long waveStart;
    private long elapsedTime;
    private LinkedList<Enemy> npcList;
    private final int MAX_PER_WAVE = 20;
    private final int ENEMIES_BEFORE_NEXT=2;
    private int waveCount;
    private int liveEnemies;


    public waveManager(LevelsType level, LinkedList<Enemy> list) {

        currentLevel = level;
        waveStart = System.nanoTime();
        npcList = list;
        waveCount = 0;
    }

    public boolean moveEnemies() {

        Enemy enemy;
        liveEnemies=0;

        for (int i = 0; i < Math.min((MAX_PER_WAVE * (1 + waveCount)),npcList.size()); i++) {

            enemy=npcList.get(i);

            if (!enemy.isDead()) {
                enemy.move();
                liveEnemies++;
            }
        }

        if (liveEnemies<=ENEMIES_BEFORE_NEXT){
            waveCount++;
        }

        return liveEnemies>0;
    }


}
