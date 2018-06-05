package org.academiadecodigo.bootcamp.Tests;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.Projectiles.Bullet;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.bootcamp.Projectiles.ProjectileFactory;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Color;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;

import static org.academiadecodigo.bootcamp.GameEngine.VectorMath.*;


/**
 * Created by codecadet on 02/06/2018.
 */
public class ProjectileTest {

    public static void main(String[] args) throws InterruptedException {


        InputManager input = new InputManager();

        Projectile[] projectiles = new Projectile[5];

        for (int i = 0; i < projectiles.length; i++) {
            projectiles[i] = ProjectileFactory.getNewProjectile();
          //  System.out.println(projectiles[i]);

        }

        Rectangle rectangle = new Rectangle(10, 10, 800, 600);
        rectangle.fill();

        double[] screenDim = Canvas.getInstance().getScreenDimentions();

        Bullet bullet = new Bullet(screenDim[0] / 2, screenDim[1] / 2);

        double[] bulletOrigin = {screenDim[0] / 2, screenDim[1] / 2};


        while (true) {
                System.out.println(input.isFiring());
            if (input.isFiring()) {

                bullet.move(normalizedVector(getVector(bulletOrigin, input.getMousePos())));
                break;
            }

        }


    }
}


