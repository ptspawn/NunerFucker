package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.util.List;

/**
 * Created by codecadet on 02/06/2018.
 */
public class movementTest {


    private List enemies;
    private List projectiles;
    private Player player;

    public static void main(String[] args) throws InterruptedException {

        InputManager input = new InputManager();

        Field field = new Field("bg.jpg");

        Player player = new Player("Sardinha", field.getWidth() / 2, field.getHeight() / 2);


        boolean[] playerDirections;


        while (true) {

            playerDirections = input.getDirections();

            if (input.isFiring()) {
                //System.out.println("Is firing");
                player.shoot(input.getMousePos());
            }

            player.move(playerDirections, input.getMousePos());

            Canvas.getInstance().repaint();

            Thread.sleep(10);

        }

    }
}
