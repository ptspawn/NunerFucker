package org.academiadecodigo.bootcamp.PowerUp;

import org.academiadecodigo.bootcamp.enums.PowerUpType;

/**
 * Created by codecadet on 10/06/2018.
 */
public class GunPowerUp extends PowerUp{

    public GunPowerUp(double[] position){
        super(PowerUpType.GUN, position);
    }
}
