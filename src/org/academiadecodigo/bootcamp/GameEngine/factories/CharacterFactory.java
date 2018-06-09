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


        for (int i = 0; i < level.getEnemyQuantity().length; i++) {

            for (int j = 0; j < level.getEnemyQuantity()[i]; j++) {
                enemies.add((Enemy)getNewCharacter(CharactersType.values()[i + 1], spawnEnemyPos()));
            }

        }



    }

    private static double[] spawnEnemyPos() {
        // 0-left;  1-right; 2-top ;3-bottom
        int side;
        double random;
        double[] spawnPos = new double[2];
        double[] screen = Game.SCREENDIMENTIONS;

        side = (int) (Math.random() * 4);
        random = Math.random();
        //spawnPos = new double[]{0, screen[0] * random};

        switch (side) {
            case 0: //xPOS = 0
                spawnPos = new double[]{-220, random * screen[1]};
                break;
            case 1: //xPOS = maxWidth
                spawnPos = new double[]{screen[0] + 220, random * screen[1]};
                break;
            case 2:
                spawnPos = new double[]{random * screen[0], -220};
                break;
            case 3:
                spawnPos = new double[]{random * screen[0], screen[1] + 220};
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
