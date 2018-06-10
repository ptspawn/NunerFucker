package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.factories.PowerUpFactory;
import org.academiadecodigo.bootcamp.enums.PowerUpType;

public class PowerUpTest {

    public static void main(String[] args) throws Exception {


        PowerUpFactory.getNewPowerUp(PowerUpType.TIME, PowerUpFactory.spawnPowerUpRandom());
        PowerUpFactory.getNewPowerUp(PowerUpType.GUN, PowerUpFactory.spawnPowerUpRandom());
        PowerUpFactory.getNewPowerUp(PowerUpType.WEED, PowerUpFactory.spawnPowerUpRandom());
        PowerUpFactory.getNewPowerUp(PowerUpType.HEALTH, PowerUpFactory.spawnPowerUpRandom());
    }

}
