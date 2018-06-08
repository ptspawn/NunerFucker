package org.academiadecodigo.bootcamp.Projectiles;

import org.academiadecodigo.bootcamp.Interfaces.ProjectileType;

/**
 * Created by codecadet on 02/06/2018.
 */
public class ProjectileFactory {

    public static Projectile shoot(ProjectileType projectileType, double[] startingPosition, double[] orientation) {

        Projectile projectile;

        switch (projectileType) {
            case BULLET:
                projectile = new Bullet(startingPosition[0], startingPosition[1], orientation);
                break;
            default:
                projectile = new Bullet(startingPosition[0], startingPosition[1], orientation);
                break;
        }
        return projectile;
    }
}
