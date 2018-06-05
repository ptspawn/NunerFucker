package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Enemy;
import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Projectiles.Projectile;

import java.awt.Rectangle;

/**
 * Created by codecadet on 04/06/2018.
 */
public class CheckCollision {

    //private List enemies;
    //private List projectiles;
    //private Player player;

    //TEST
    private Rectangle[] rectangles1;
    private Rectangle[] rectangles2;


    public CheckCollision(Rectangle[] rectangles1, Rectangle[] rectangles2) {

        this.rectangles1 = rectangles1;
        this.rectangles2 = rectangles2;

        // this.projectiles = projectiles;
        //this.enemies = enemies;
        //this.player = player;
    }

    public double getDistance(Rectangle d, Rectangle o) {

        return Math.sqrt((Math.pow(d.getCenterX() - o.getCenterX(), 2) + Math.pow(d.getCenterY() - o.getCenterY(), 2)));
    }

    // Check projectile vs Enemy

    public boolean check() {

        double hitDistance;


        for (Rectangle d : rectangles1) {
            for (Rectangle o : rectangles2) {

                hitDistance = o.getHeight() / 2 + d.getHeight() / 2;


                if (getDistance(d, o) < hitDistance) {
                    System.out.println("true");
                    return truexcode-select --install

                    ;
                }
                else {
                    System.out.println("false");
                    return false;
                }
            }                        

        }
        System.out.println("false");
        return false;
    }
}


