package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.Projectiles.Bullet;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;


/**
 * Created by codecadet on 02/06/2018.
 */
public class ProjectileTest {

    public static void main(String[] args) throws InterruptedException {


        InputManager input = new InputManager();

        Projectile[] projectiles = new Projectile[5];

        //  for (int i = 0; i < projectiles.length; i++) {
        //      projectiles[i] = ProjectileFactory.getNewProjectile();
        //  }

        //Rectangle rectangle = new Rectangle(10, 10, 800, 600);
        //rectangle.fill();

        double[] screenDim = Canvas.getInstance().getScreenDimentions();


        double[] bulletOrigin = {screenDim[0] / 2, screenDim[1] / 2};


        double[] orientationVector = {1, 1};
        Bullet bullet = new Bullet(screenDim[0] / 2, screenDim[1] / 2, orientationVector);//normalizedVector(getVector(bulletOrigin,input.getMousePos())));//null;
        //bullet.draw();
        Canvas.getInstance().repaint();
        //bullet.move();


        while (true) {
            System.out.println(input.isFiring());

            //if (input.isFiring()) {
            //    bullet = new Bullet(screenDim[0] / 2, screenDim[1] / 2, getVector(bulletOrigin, input.getMousePos()));
            //}
            //if (bullet != null) {
                bullet.move();
            //}

            Canvas.getInstance().repaint();

            Thread.sleep(200);

        }


    }

}


