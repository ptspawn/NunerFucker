package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.bootcamp.GameEngine.factories.CharacterFactory;
import org.academiadecodigo.bootcamp.enums.LevelsType;
import org.academiadecodigo.bootcamp.MenuScreens.Hud;
import org.academiadecodigo.bootcamp.MenuScreens.MainMenu;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

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

        enemies = new LinkedList<>();

        projectiles = new LinkedList<>();

        Projectile currentShot = null;

        Field field = new Field("bg.jpg");

        CharacterFactory.enemySpawnByLevel(LevelsType.VIRGIN, enemies);

        player = new Player("Sardinha", field.getWidth() / 2, field.getHeight() / 2);

        WaveManager waveManager=new WaveManager(LevelsType.VIRGIN,enemies,player);

        Hud hud = new Hud();

        int liveEnemies;


        while (!player.isDead()) {

            playerDirections = input.getDirections();

            if (input.isFiring()) {

                if ((currentShot = player.shoot(input.getMousePos())) != null) {

                    projectiles.add(currentShot);

                }

            }

            moveProjectiles();

            //moveEnemies();

            liveEnemies=waveManager.moveEnemies();

            player.move(playerDirections, input.getMousePos());

            Canvas.getInstance().repaint();

            if (liveEnemies==0){



            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("ERROR");

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
            if (enemy.isDead()){continue;}

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
