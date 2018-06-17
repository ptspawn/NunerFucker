package org.academiadecodigo.bootcamp.enums;

/**
 * Created by codecadet on 08/06/2018.
 */
public enum LevelsType {

    VIRGIN(new int[][][]{
            {{500, 0}, {1, 10}, {2, 20}, {3, 5}},
            {{800, 0}, {1, 30}, {2, 40}, {3, 40}},
            {{1000, 0}, {2, 50}, {7, 1}}
    }),

    EXPERIENT(new int[][][]{
            {{500, 0}, {1, 20}, {2, 25}, {3, 20}},
            {{800, 0}, {1, 30}, {2, 40}, {3, 40}, {5, 20}, {6, 15}},
            {{1000, 0}, {2, 50}, {3, 20}, {7, 1}}
    });

    /*USED(new int[][]{{500, 15, 10, 0, 0, 0, 0}, {500, 10, 10, 15, 0, 0, 0, 0},
            {1000, 0, 20, 15, 20, 0, 0, 0}, {1500, 0, 0, 0, 30, 25, 10, 0}, {0, 0, 0, 0, 20, 20, 35, 1}}),

    SLUT(new int[][]{{500, 15, 10, 0, 0, 0, 0}, {500, 10, 10, 15, 0, 0, 0, 0},
            {1000, 0, 20, 15, 20, 0, 0, 0}, {1500, 0, 0, 0, 30, 25, 10, 0}, {0, 0, 0, 0, 20, 20, 35, 1}}),

    XXX(new int[][]{{500, 15, 10, 0, 0, 0, 0}, {500, 10, 10, 15, 0, 0, 0, 0},
            {1000, 0, 20, 15, 20, 0, 0, 0}, {1500, 0, 0, 0, 30, 25, 10, 0}, {0, 0, 0, 0, 20, 20, 35, 1}});*/


    private int waves[][][];
    private int enemyCountByWave[];
    private int cycleCountByWave[];

    LevelsType(int[][][] levelDefs) {

        waves = levelDefs;
        enemyCountByWave = new int[waves.length];
        cycleCountByWave = new int[waves.length];

        for (int i = 0; i < waves.length; i++) {

            enemyCountByWave[i] = getTotalEnemiesTilWave(i);
            cycleCountByWave[i] = getTotalCyclesTilWave(i);
            System.out.println(cycleCountByWave[i]);
        }


    }


    public int[][] getWave(int waveNumber) {

        return waves[waveNumber];

    }

    public int getEnemyCountbyWave(int waveNumber) {

        if (waveNumber >= enemyCountByWave.length) {
            return enemyCountByWave[enemyCountByWave.length - 1];
        }

        return enemyCountByWave[waveNumber];
    }

    public int getCycleLimitByWave(int waveNumber) {

        if (waveNumber >= cycleCountByWave.length) {
            return cycleCountByWave[cycleCountByWave.length - 1];
        }

        return cycleCountByWave[waveNumber];
    }

    private int getTotalEnemiesTilWave(int waveNumber) {

        int result = 0;

        for (int i = 0; i <= waveNumber; i++) {

            for (int e = 1; e < waves[i].length; e++) {

                result += waves[i][e][1];

            }

        }

        return result;

    }

    private int getTotalCyclesTilWave(int waveNumber) {

        int result = 0;

        for (int i = 0; i <= waveNumber; i++) {

            result += waves[i][0][0];
        }

        return result;

    }


    public int getWaveCount() {
        return waves.length;
    }


}


