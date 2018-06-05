package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.util.List;


/**
 * Created by codecadet on 02/06/2018.
 */
public class Game {

    private Field field;
    private List enemies;
    private List projectiles;
    private Player player;
    public static double[] SCREENDIMENTIONS;
    private boolean[] playerDirections;
    private InputManager input;

    public Game() throws InterruptedException {
        input = new InputManager();

        Field field = new Field("bg.jpg");
        SCREENDIMENTIONS = Canvas.getInstance().getScreenDimentions();


    }


    public void start()throws InterruptedException {

        Hud hud = new Hud();

        Player player = new Player("Sardinha", field.getWidth() / 2, field.getHeight() / 2);


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
