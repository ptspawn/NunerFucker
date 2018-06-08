package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.bootcamp.MenuScreens.MainMenu;
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

    public Game() {
        input = new InputManager();

        SCREENDIMENTIONS = Canvas.getInstance().getScreenDimentions();
        MainMenu mainMenu = new MainMenu();

        double[] mousePosition;

        while (true) {

            mousePosition = input.getMousePos();

            ;

            if (input.isFiring() && mainMenu.checkButtons(mousePosition)!=0){

            }


            Canvas.getInstance().repaint();

            try {
                Thread.sleep(50);
            }catch(InterruptedException e){
                System.out.println("Ups");
            }

        }

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
