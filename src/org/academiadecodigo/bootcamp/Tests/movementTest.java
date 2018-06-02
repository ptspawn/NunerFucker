package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Characters.pTest;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.GameEngine.Hud;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;

import java.util.List;

/**
 * Created by codecadet on 02/06/2018.
 */
public class movementTest {


    private List enemies;
    private List projectiles;
    private pTest player;

    public static void main(String[] args) throws InterruptedException{


        Field field = new Field("bg.jpg");

        Hud hud = new Hud();

        pTest player = new pTest("Sardinha", field.getWidth() / 2, field.getHeight() / 2);

        InputManager input = new InputManager(player,hud,field);


        boolean[] playerDirections;

        while (true){

            playerDirections=input.getDirections();

            if (input.isFiring()){ player.shoot();}

            player.move(playerDirections);

            Thread.sleep(20);

        }

    }
}
