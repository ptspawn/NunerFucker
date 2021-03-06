package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.enums.CharactersType;
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

        double[] normalizedVector = {0, 0};

        double h = Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2));

        if (h != 0) {
            normalizedVector[0] = vector[0] / h;
            normalizedVector[1] = vector[1] / h;
        }

        return normalizedVector;

    }


    public static double getRotationFromMousePos(double[] mousePos, Picture picToRotate, double imgRotation) {

        double[] picCenter = new double[2];

        picCenter[0] = picToRotate.getX() + picToRotate.getWidth() / 2;
        picCenter[1] = picToRotate.getY() + picToRotate.getHeight() / 2;

        double[] vector = new double[2];

        vector[0] = mousePos[0] - picCenter[0];
        vector[1] = mousePos[1] - picCenter[1];

        double angle = Math.atan(vector[1] / vector[0]);

        if (vector[0] < 0) {
            angle = angle + imgRotation + 2 * Math.PI;
        }
        if (angle + imgRotation > 2 * Math.PI) {
            angle = angle + imgRotation - 2 * Math.PI;
        }

        return angle + imgRotation;
    }

    public static double getRotationFromVector(double[] vector, Picture picToRotate, double imgRotation) {

        double[] picCenter = new double[2];

        picCenter[0] = picToRotate.getX() + picToRotate.getWidth() / 2;
        picCenter[1] = picToRotate.getY() + picToRotate.getHeight() / 2;

        double angle = Math.atan(vector[1] / vector[0]);

        if (vector[0] < 0) {
            angle = angle + imgRotation + 2 * Math.PI;
        }
        if (angle + imgRotation > 2 * Math.PI) {
            angle = angle + imgRotation - 2 * Math.PI;
        }

        return angle + imgRotation;
    }

    public static double[] getDeviatedNormalizedVector(double[] vector, CharactersType type){

        double xDeviated=vector[0]+((int)(Math.random()*2*type.getDirectionGap()-type.getDirectionGap()));

        double yDeviated = vector[1]+((int)(Math.random()*2*type.getDirectionGap()-type.getDirectionGap()));

        double[] result = {xDeviated,yDeviated};

        return normalizedVector(result);

    }

    private static double[]  PerpendicularClockwise(double[] vector,CharactersType type) {

        double result[] = {vector[1]*type.getDirectionGap(),-vector[0]*type.getDirectionGap()};

        return result;
    }

    private static double[] PerpendicularCounterClockwise(double[] vector, CharactersType type) {

        double result[] = {-vector[1]*type.getDirectionGap(),vector[0]*type.getDirectionGap()};

        return result;
    }

}
