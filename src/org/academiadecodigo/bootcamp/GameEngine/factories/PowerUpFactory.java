package org.academiadecodigo.bootcamp.GameEngine.factories;

import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.PowerUp.*;
import org.academiadecodigo.bootcamp.enums.PowerUpType;

import java.util.LinkedList;

import static org.academiadecodigo.bootcamp.enums.PowerUpType.HEALTH;

/**
 * Created by codecadet on 10/06/2018.
 */
public class PowerUpFactory {

    public static PowerUp getNewPowerUp(PowerUpType powerUpType, double[] startingPosition) {

        PowerUp powerUp;

        switch (powerUpType) {
            case HEALTH:
                powerUp = new HealthPowerUp(startingPosition);
                break;
            case TIME:
                powerUp = new TimePowerUp(startingPosition);
                break;
            case GUN:
                powerUp = new GunPowerUp(startingPosition);
                break;
            case WEED:
                powerUp = new WeedPowerUp(startingPosition);
                break;
            default:
                powerUp = null;
        }
        return powerUp;
    }

    public static double[] spawnPowerUpRandom() {

        double[] spawnPos = new double[2];
        double[] screen = Game.SCREENDIMENTIONS;

        spawnPos[0] = (int) (Math.random() * screen[0]);
        spawnPos[1] = (int) (Math.random() * screen[1]);
        return spawnPos;
    }

    public static PowerUp getNewPowerUp(double[] startingPosition) {

        PowerUpType type = PowerUpType.values()[(int) (Math.random() * PowerUpType.values().length-1)];

        return getNewPowerUp(type, startingPosition);
    }

}
