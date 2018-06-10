package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.PowerUp.HealthPowerUp;

public class PowerUpTest {

    public static void main(String[] args) throws Exception {

        HealthPowerUp pu = new HealthPowerUp(5,3);
        pu.draw();
        Thread.sleep(5000);
        pu.setCaught();


    }

}
