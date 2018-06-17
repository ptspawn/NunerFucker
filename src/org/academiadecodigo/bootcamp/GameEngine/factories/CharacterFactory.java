package org.academiadecodigo.bootcamp.GameEngine.factories;

import org.academiadecodigo.bootcamp.Characters.Character;
import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.enums.CharactersType;
import org.academiadecodigo.bootcamp.enums.LevelsType;

import java.util.LinkedList;

/**
 * Created by codecadet on 02/06/2018.
 */
public class CharacterFactory {

    public static void enemySpawnByLevel(LevelsType level, LinkedList<Enemy> enemies) {

        int[][] currentWave;

        for (int z = 0; z < level.getWaveCount(); z++) {

            currentWave=level.getWave(z);

            for (int i = 1; i < currentWave.length; i++) {

                for (int e = 0; e < currentWave[i][1]; e++) {

                    int currentEnemy=currentWave[i][0];

                    enemies.add((Enemy)getNewCharacter(CharactersType.values()[currentEnemy], spawnEnemyPos()));

                    //System.out.println("Wave " + z + " - Enemy type " + currentEnemy + " spawned" );
                }

            }

        }





    }

    private static double[] spawnEnemyPos() {
        // 0-left;  1-right; 2-top ;3-bottom
        int side;
        double random;
        double[] spawnPos = new double[2];
        double[] screen = Game.SCREENDIMENTIONS;
        int paddingSpawn = 250;

        side = (int) (Math.random() * 4);
        random = Math.random();
        //spawnPos = new double[]{0, screen[0] * random};

        switch (side) {
            case 0: //xPOS = 0
                spawnPos = new double[]{-paddingSpawn, random * screen[1]};
                break;
            case 1: //xPOS = maxWidth
                spawnPos = new double[]{screen[0] + paddingSpawn, random * screen[1]};
                break;
            case 2:
                spawnPos = new double[]{random * screen[0], -paddingSpawn};
                break;
            case 3:
                spawnPos = new double[]{random * screen[0], screen[1] + paddingSpawn};
                break;

        }
        return spawnPos;
    }


    public static Character getNewCharacter(CharactersType charactersType, double[] startingPosition) {

        Character character;

        switch (charactersType) {
            case PLAYER:
                character = new Player("Sardinha", startingPosition[0], startingPosition[1]);
                break;
            case ENEMY:
                character = new Enemy(startingPosition, CharactersType.ENEMY);
                break;
            case BUG:
                character = new Enemy(startingPosition, CharactersType.BUG);
                break;
            case SPIDER:
                character = new Enemy(startingPosition, CharactersType.SPIDER);
                break;
            case HUMAN:
                character = new Enemy(startingPosition, CharactersType.HUMAN);
                break;
            case SPACESHIP:
                character = new Enemy(startingPosition, CharactersType.SPACESHIP);
                break;
            case ZOMBIE:
                character = new Enemy(startingPosition, CharactersType.ZOMBIE);
                break;
            case ZOMBIEBOSS:
                character = new Enemy(startingPosition, CharactersType.ZOMBIEBOSS);
                break;
            default:
                character = new Enemy(startingPosition, CharactersType.ENEMY);
                break;
        }
        return character;
    }
}
