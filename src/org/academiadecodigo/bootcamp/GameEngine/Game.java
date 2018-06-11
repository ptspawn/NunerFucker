package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.bootcamp.GameEngine.factories.CharacterFactory;
import org.academiadecodigo.bootcamp.GameEngine.factories.PowerUpFactory;
import org.academiadecodigo.bootcamp.MenuScreens.GameOverMenu;
import org.academiadecodigo.bootcamp.MenuScreens.Pause;
import org.academiadecodigo.bootcamp.PowerUp.PowerUp;
import org.academiadecodigo.bootcamp.Projectiles.Bullet;
import org.academiadecodigo.bootcamp.enums.LevelsType;
import org.academiadecodigo.bootcamp.MenuScreens.Hud;
import org.academiadecodigo.bootcamp.MenuScreens.MainMenu;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.bootcamp.enums.PowerUpType;
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
    public static LinkedList<PowerUp> powerUps;
    private Player player;
    public static double[] SCREENDIMENTIONS;
    public static int SCORE;
    public static int BULLETTIME;
    public static int FIRE_RATE_MODIFIER;


    private boolean[] playerDirections;
    private InputManager input;
    private Hud hud;
    private int cycleCount;
    private int currentLevel;

    private GameOverMenu gameOver;
    private MainMenu mainMenu;

    private Picture redFlash;
    private Pause pause;

    private boolean bulletTime;
    private int bulletTImeCounter;
    private boolean machineGun;
    private int machineGunCounter;
    private boolean flashOn;

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
                        currentLevel = 1;
                        start(LevelsType.values()[currentLevel - 1]);
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

        SCORE = 0;

        BULLETTIME = 1;
        FIRE_RATE_MODIFIER = 1;

        cycleCount = 0;

        cleanScreen();

        enemies = new LinkedList<>();

        projectiles = new LinkedList<>();

        powerUps = new LinkedList<>();

        Projectile currentShot = null;


        if (field == null) {

            field = new Field("bg.jpg");
            field.draw();

        } else {

            field.draw();
            cleanScreen();
        }

        CharacterFactory.enemySpawnByLevel(level, enemies);

        //if (player==null) {
        player = new Player("Sardinha", field.getWidth() / 2, field.getHeight() / 2);
        //}

        WaveManager waveManager = new WaveManager(level, enemies, player);

        if (hud == null) {
            hud = new Hud();
            hud.showHud();
        } else {
            hud.showHud();

        }


        if (redFlash == null) {
            redFlash = new Picture(0, 0, "Bgs/red.png");
            redFlash.scaleToFit(SCREENDIMENTIONS[0], SCREENDIMENTIONS[1]);

        }

        if (pause == null) {
            pause = new Pause();
        }

        int liveEnemies = -1;

        gameLoop.playSound();


        while (!player.isDead() && liveEnemies != 0) {

            if (cycleCount++ % 50 == 0) {
                SCORE++;
            }

            if (player.tookDamage() && !flashOn) {
                redFlash.draw();
                flashOn = true;
            }

            if (!player.tookDamage() && flashOn) {
                redFlash.delete();
                flashOn = false;
            }

            if (input.isPaused) {

                gameLoop.stopSound();
                pause.show();

                while (input.isPaused) {

                    pause.animate();
                    Canvas.getInstance().repaint();

                    try {
                        Thread.sleep(20);
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

            checkPowerUps();

            manageEffects();

            hud.setLife(player.getHealth());
            hud.incrementScore(SCORE);

            Canvas.getInstance().repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("ERROR");

            }


        }

        hud.hideHud();

        gameLoop.stopSound();

        if (liveEnemies == 0){
            System.out.println("ended level");
           // ++currentLevel <= LevelsType.values().length

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("deu merda");
            } finally {

                if (++currentLevel<LevelsType.values().length) {
                    start(LevelsType.values()[currentLevel]);
                } else {
                    System.out.println("You beat the game!");

                }
            }

        }

        showGameOver();

    }

    private void manageEffects() {

        if (BULLETTIME != 1 && !bulletTime) {

            System.out.println(cycleCount + "Entered bulletTIme");
            bulletTime = true;
            bulletTImeCounter = cycleCount;

        }

        if (bulletTime && bulletTImeCounter + PowerUpType.TIME.getValue() < cycleCount) {
            System.out.println(cycleCount + "Left bulletTIme");
            BULLETTIME = 1;
            bulletTime = false;

        }

        if (FIRE_RATE_MODIFIER != 1 && !machineGun) {

            System.out.println(cycleCount + "Got machine Gun");
            machineGun = true;
            machineGunCounter = cycleCount;

        }

        if (machineGun && machineGunCounter + PowerUpType.GUN.getValue() < cycleCount) {
            System.out.println(cycleCount+" lostMachineGun ");
            FIRE_RATE_MODIFIER = 1;
            machineGun = false;

        }


    }

    private void cleanScreen() {

        if (enemies != null) {
            for (Enemy enemy : enemies) {
                if (!enemy.isDead()) {
                    enemy.hide();
                }
            }
        }
        if (projectiles != null) {
            for (Projectile projectile : projectiles) {

                ((Bullet) projectile).hide();
            }
        }

        if (powerUps != null) {
            for (PowerUp powerUp : powerUps) {
                powerUp.setCaught();
            }
        }
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
                        currentLevel = 1;
                        start(LevelsType.values()[currentLevel - 1]);
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


    private void checkPowerUps() {

        PowerUp powerUp;
        double collisionRadius;

        for (int i = 0; i < powerUps.size(); i++) {

            powerUp = powerUps.get(i);
            collisionRadius = player.getCollisionRadius() + powerUp.getCollisionRadius();

            if (Collider.checkCollision(player.getPosition(), powerUp.getPosition(), collisionRadius)) {

                player.catchPowerup(powerUp.getType());
                powerUp.setCaught();
                powerUps.remove(i);
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
