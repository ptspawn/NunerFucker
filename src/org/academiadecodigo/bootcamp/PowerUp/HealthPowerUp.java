package org.academiadecodigo.bootcamp.PowerUp;

import org.academiadecodigo.bootcamp.enums.PowerUpType;


public class HealthPowerUp extends PowerUp {


    public HealthPowerUp(double xPos, double yPos){
      super(PowerUpType.HEALTH);
      super.setPowerUp(PowerUpType.HEALTH.getPath(), xPos, yPos);
      super.draw();
    }


}
