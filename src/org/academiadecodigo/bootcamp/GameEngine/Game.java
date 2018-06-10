package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.bootcamp.GameEngine.factories.CharacterFactory;
import org.academiadecodigo.bootcamp.MenuScreens.GameOverMenu;
import org.academiadecodigo.bootcamp.MenuScreens.Pause;
import org.academiadecodigo.bootcamp.enums.LevelsType;
import org.academiadecodigo.bootcamp.MenuScreens.Hud;
import org.academiadecodigo.bootcamp.MenuScreens.MainMenu;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.bootcamp.enums.SoundType;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.LinkedList;


/**
 * Created by codecadet on 02/06/2018.
 */
public class Game {

    private Field field;
    private LinkedList<Enemy> enemies;
    private LinkedList<Projectile> projectiles;
    private Player player;
    public static double[] SCREENDIMENTIONS;
    private boolean[] playerDirections;
    private InputManager input;
    private Hud hud;

    private GameOverMenu gameOver;
    private MainMenu mainMenu;

    private Picture redFlash;
    private Pause pause;

    private SoundType gameLoop = SoundType.BACKGROUND2;


    public Game() {
        input = new InputManager();

        SCREENDIMENTIONS = Canvas.getInstance().getScreenDimentions();

        showMainMenu();
    }

    private void showMainMenu() {

        if (mainMenu == null) {
            mainMenu = new MainMenu();
        }

        mainMenu.show();

        double[] mousePosition;

        while (true) {

            mousePosition = input.getMousePos();
            int result = 0;

            if ((result = mainMenu.checkButtons(mousePosition)) != 0 && input.isFiring()) {

                switch (result) {

                    case 1:
                        mainMenu.hide();
                        start(LevelsType.VIRGIN);
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

    public void start(LevelsType level) {

        enemies = new LinkedList<>();

        projectiles = new LinkedList<>();

        Projectile currentShot = null;


        if (field == null) {

            field = new Field("bg.jpg");

        } else {

            field.draw();
        }

        CharacterFactory.enemySpawnByLevel(level, enemies);

        //if (player==null) {
        player = new Player("Sardinha", field.getWidth() / 2, field.getHeight() / 2);
        //}

        WaveManager waveManager = new WaveManager(level, enemies, player);

        if (hud == null) {
            hud = new Hud();
        } else {

        }

        if (redFlash == null) {
            redFlash = new Picture(0, 0, "Bgs/red.png");
        }

        if (pause == null) {
            pause = new Pause();
        }

        int liveEnemies = -1;

        gameLoop.playSound();


        while (!player.isDead() || liveEnemies == 0) {


            if (input.isPaused) {
                
                gameLoop.stopSound();
                pause.show();

                while (input.isPaused) {

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.out.println("merda");
                    }
                }

                pause.hide();

                gameLoop.playSound();
            }

            playerDirections = input.getDirections();

            if (input.isFiring()) {

                if ((currentShot = player.shoot(input.getMousePos())) != null) {

                    projectiles.add(currentShot);

                }

            }

            moveProjectiles();

            player.move(playerDirections, input.getMousePos());

            liveEnemies = waveManager.moveEnemies();

            Canvas.getInstance().repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("ERROR");

            }


        }

        field.hide();

        SoundType.BACKGROUND4.stopSound();

        showGameOver();

    }


    private void showGameOver() {

        if (gameOver == null) {
            gameOver = new GameOverMenu();
        }

        gameOver.show();

        double[] mousePosition;

        while (true) {

            mousePosition = input.getMousePos();
            int result = 0;

            if ((result = gameOver.checkButtons(mousePosition)) != 0 && input.isFiring()) {

                switch (result) {

                    case 1:
                        gameOver.hide();
                        start(LevelsType.VIRGIN);
                    case 2:
                        gameOver.hide();
                        showMainMenu();

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


    private void moveEnemies() {

        Enemy enemy;
        double collisionRadius;

        for (int i = 0; i < enemies.size(); i++) {

            enemy = enemies.get(i);
            enemy.move(player.getPosition());
            collisionRadius = player.getCollisionRadius() + enemy.getCollisionRadius();


            if (Collider.checkCollision(player.getPosition(), enemy.getPosition(), collisionRadius)) {

                player.getHit(enemy.getDamage());
            }

        }

    }

    private void moveProjectiles() {

        Projectile projectile;

        for (int i = 0; i < projectiles.size(); i++) {
            projectile = projectiles.get(i);

            if (projectile.move() || projectileCollider(projectile)) {
                projectile.delete();
                projectiles.remove(i);
            }

        }

    }

    private boolean projectileCollider(Projectile projectile) {

        boolean result = false;
        int collideDistance;
        Enemy enemy;

        for (int i = 0; i < enemies.size(); i++) {

            enemy = enemies.get(i);
            if (enemy.isDead()) {
                continue;
            }

            collideDistance = enemy.getCollisionRadius() + projectile.getCollisionRadius();

            if (Collider.checkCollision(enemy.getPosition(), projectile.getPosition(), collideDistance)) {
                result = true;
                System.out.println("Enemy got hit");
                enemy.getHit(projectile.getDamage());
                break;

            }

        }

        return result;
    }

}
