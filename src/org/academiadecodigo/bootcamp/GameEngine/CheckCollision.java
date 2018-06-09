package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public class CheckCollision {

    private static double[] getCenter(Picture r) {

        double[] center = {r.getX() + r.getWidth() / 2, r.getY() + r.getHeight() / 2};

        return center;
    }

    private static double getDistance(Picture destination, Picture origin) {

        double[] centerDestination = getCenter(destination);
        double[] centerOrigin = getCenter(origin);

        return Math.sqrt((Math.pow(centerDestination[0] - centerOrigin[0], 2)
                + Math.pow(centerDestination[1] - centerOrigin[1], 2)));
    }

    private static double getDistance(double[] origin, double[] destination){

        return Math.sqrt((Math.pow(destination[0] - origin[0], 2)
                + Math.pow(destination[1] - origin[1], 2)));
    }

    // Check projectile vs Enemy

    public static boolean checkCollision(Picture origin, Picture destination, double hitDistance) {


        if (getDistance(destination, origin) < hitDistance) {
            return true;
        }
        return false;

    }

    public static boolean checkCollision(double[] origin, double[] destination, double hitDistance) {


        if (getDistance(destination, origin) < hitDistance) {
            return true;
        }
        return false;

    }
}


