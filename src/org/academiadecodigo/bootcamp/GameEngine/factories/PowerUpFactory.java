package org.academiadecodigo.bootcamp.GameEngine.factories;

import org.academiadecodigo.bootcamp.PowerUp.*;
import org.academiadecodigo.bootcamp.enums.PowerUpType;

/**
 * Created by codecadet on 10/06/2018.
 */
public class PowerUpFactory {
    public PowerUp getNewPowerUp(PowerUpType powerUpType, double[] startingPosition) {

        PowerUp powerUp;

        switch (powerUpType) {
            case HEALTH:
                powerUp = new HealthPowerUp(startingPosition[0], startingPosition[1]);
                break;
            case TIME:
                powerUp = new TimePowerUp(startingPosition[0], startingPosition[1]);
                break;
            case GUN:
                powerUp = new GunPowerUp(startingPosition[0], startingPosition[1]);
                break;
            case WEED:
                powerUp = new WeedPowerUp(startingPosition[0], startingPosition[1]);
                break;
            default:
                powerUp = null;
        }
        return powerUp;
    }
}
