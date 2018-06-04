package org.academiadecodigo.bootcamp.Tests;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.academiadecodigo.bootcamp.Projectiles.Bullet;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.bootcamp.Projectiles.ProjectileFactory;
import org.academiadecodigo.notsosimplegraphics.graphics.Color;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;


/**
 * Created by codecadet on 02/06/2018.
 */
public class ProjectileTest {

    public static void main(String[] args) throws InterruptedException  {



        Projectile[] projectiles = new Projectile[5];

        for (int i = 0; i < projectiles.length; i++) {
            projectiles[i] = ProjectileFactory.getNewProjectile();
            System.out.println(projectiles[i]);

        }

        Rectangle rectangle = new Rectangle(10, 10, 800, 600);
        rectangle.fill();
        Rectangle bullet = new Rectangle(100, 50, 10, 5);
        bullet.fill();
        bullet.setColor(Color.RED);

        int move = bullet.getX() + 300;

        while (bullet.getX() < move){
            Thread.sleep(20);
            bullet.translate(5,5);
        }




    }


}
