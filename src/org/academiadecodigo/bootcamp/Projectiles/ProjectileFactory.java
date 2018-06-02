package org.academiadecodigo.bootcamp.Projectiles;

import org.academiadecodigo.bootcamp.Interfaces.ProjectileType;

/**
 * Created by codecadet on 02/06/2018.
 */
public class ProjectileFactory {

    public static Projectile getNewProjectile() {

        int random = (int) (Math.random() * ProjectileType.values().length);

        //random gun
        ProjectileType projectileType = ProjectileType.values()[random];

        Projectile projectile;

        switch (projectileType) {
            case BULLET:
                projectile = new Bullet();
                break;
            default:
                projectile = new Bullet();
                break;
        }
        return projectile;
    }
}
