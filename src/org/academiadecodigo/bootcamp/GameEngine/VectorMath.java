package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 02/06/2018.
 */
public class VectorMath {

    public static double[] getVector(double[] origin, double[] destination) {

        double[] vector = {destination[0] - origin[0], destination[1] - origin[1]};

        return vector;


    }

    public static double[] normalizedVector(double[] vector) {

        double h = Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2));

        if (h != 0) {
            double[] normalizedVector = {vector[0] / h, vector[1] / h};
            return normalizedVector;
        }

        //if h is zero... then return [0,0]

        double emptyVector[] = {0, 0};

        return emptyVector;

    }

    public static double getRotationFromVector(double[] mousePos, Picture picToRotate, double buffer) {

        double[] picCenter = new double[2];

        picCenter[0] = picToRotate.getX() + picToRotate.getWidth() / 2;
        picCenter[1] = picToRotate.getY() + picToRotate.getHeight() / 2;

        double[] vector = new double[2];

        vector[0] = mousePos[0] - picCenter[0];
        vector[1] = mousePos[1] - picCenter[1];

        double angle = Math.atan(vector[1] / vector[0]);

        if (vector[0] < 0) {
            angle = angle + buffer + 2 * Math.PI;
        }
        if (angle + buffer > 2 * Math.PI) {
            angle = angle + buffer - 2 * Math.PI;
        }

        return angle;
    }


}
