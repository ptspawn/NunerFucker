package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Projectiles.Projectile;
import org.academiadecodigo.bootcamp.Projectiles.ProjectileFactory;

/**
 * Created by codecadet on 02/06/2018.
 */
public class ProjectileTest {

    public static void main(String[] args) {
        Projectile[] projectiles = new Projectile[5];

        for (int i = 0; i < projectiles.length; i++) {
            projectiles[i] = ProjectileFactory.getNewProjectile();
            System.out.println(projectiles[i]);
        }
    }



}
