package org.academiadecodigo.bootcamp.PowerUp;

import org.academiadecodigo.bootcamp.enums.PowerUpType;

/**
 * Created by codecadet on 10/06/2018.
 */
public class TimePowerUp extends PowerUp {

    public TimePowerUp(double xPos, double yPos) {
        super(PowerUpType.TIME);
        setPowerUp(PowerUpType.TIME.getPath(), xPos, yPos);
    }
}
