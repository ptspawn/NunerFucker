package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.bootcamp.Interfaces.CharactersType;
import org.academiadecodigo.bootcamp.MenuScreens.MainMenu;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.util.LinkedList;
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
            int result = 0;

            if ((result = mainMenu.checkButtons(mousePosition)) != 0 && input.isFiring()) {

                switch (result) {

                    case 1:
                        start();
                    case 2:
                        System.exit(0);

                }

            }

            Canvas.getInstance().repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Ups");
            }

        }

    }

    public void start() {

        enemies = new LinkedList<Enemy>();
        projectiles=new LinkedList<Projectile>();

       /* double[] temp = {100, 700};
        double[] temp2 = {SCREENDIMENTIONS[0] - 20, 20};
        double[] temp3 = {SCREENDIMENTIONS[0] - 20, SCREENDIMENTIONS[1] - 20};
        enemies.add(new Enemy(temp, CharactersType.ENEMY));
        enemies.add(new Enemy(temp2,CharactersType.ENEMY));
        enemies.add(new Enemy(temp3,CharactersType.ENEMY));*/

        Field field = new Field("bg.jpg");

        Hud hud = new Hud();

        player = new Player("Sardinha", field.getWidth() / 2, field.getHeight() / 2);


        while (!player.isDead()) {

            playerDirections = input.getDirections();

            if (input.isFiring()) {
                //System.out.println("Is firing");
                projectiles.add(player.shoot(input.getMousePos()));
            }

            player.move(playerDirections, input.getMousePos());

            Canvas.getInstance().repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("ERROR");

            }
        }

    }


}
