package org.academiadecodigo.bootcamp.PowerUp;

import org.academiadecodigo.bootcamp.enums.PowerUpType;


public class HealthPowerUp extends PowerUp {

    private double collisionRadius;

    public HealthPowerUp(double xPos, double yPos){
      super(PowerUpType.HEALTH);
      super.setPowerUp("Resources/PowerUps/Power-ups/PNG/life_power_up_1.png", xPos, yPos);
      super.draw();
    }


    @Override
    public int getCollisionRadius() {
        return (int)collisionRadius;
    }

}
