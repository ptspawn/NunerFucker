package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.bootcamp.GameEngine.Hud;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.Interfaces.CharactersType;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.util.LinkedList;
import java.util.List;


public class EnemyTest {

    private Field field;
    private static List<Enemy> enemies;
    private static List<Projectile> projectiles;
    private static Player player;
    public static double[] SCREENDIMENTIONS;
    private static boolean[] playerDirections;
    private InputManager input;

    public static void main(String[] args) throws InterruptedException {

        InputManager input = new InputManager();

        Field field = new Field("bg.jpg");
        SCREENDIMENTIONS = Canvas.getInstance().getScreenDimentions();
        enemies = new LinkedList<Enemy>();
        double[] temp = {100, 700};
        double[] temp2 = {SCREENDIMENTIONS[0] - 20, 20};
        double[] temp3 = {SCREENDIMENTIONS[0] - 20, SCREENDIMENTIONS[1] - 20};
        enemies.add(new Enemy(temp, CharactersType.ENEMY));
        enemies.add(new Enemy(temp2,CharactersType.ENEMY));
        enemies.add(new Enemy(temp3,CharactersType.ENEMY));



        Hud hud = new Hud();

        Player player = new Player("Sardinha", field.getWidth() / 2, field.getHeight() / 2);


        while (true) {

            playerDirections = input.getDirections();

            if (input.isFiring()) {
                //System.out.println("Is firing");
                player.shoot(input.getMousePos());
            }

            player.move(playerDirections, input.getMousePos());
            moveEnemies(player);

            Canvas.getInstance().repaint();

            Thread.sleep(20);
        }

    }

    public static void moveEnemies(Player player) {

        System.out.println(player);

        for (Enemy enemy : enemies) {

            System.out.println(enemy);
            enemy.move(player.getPosition());
        }

    }

    public static void moveBullets() {
        for (Projectile projectile : projectiles) {
            projectile.move();
        }

    }
}



