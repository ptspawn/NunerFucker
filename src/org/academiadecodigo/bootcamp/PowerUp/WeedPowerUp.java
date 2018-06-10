package org.academiadecodigo.bootcamp.PowerUp;

import org.academiadecodigo.bootcamp.enums.PowerUpType;

/**
 * Created by codecadet on 10/06/2018.
 */
public class WeedPowerUp extends PowerUp {

    public WeedPowerUp(double xPos, double yPos){
        super(PowerUpType.WEED);
        super.setPowerUp(PowerUpType.WEED.getPath(), xPos, yPos );
        super.draw();


    }

}
