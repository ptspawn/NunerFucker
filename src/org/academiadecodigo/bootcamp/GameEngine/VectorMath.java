package org.academiadecodigo.bootcamp.GameEngine;

/**
 * Created by codecadet on 02/06/2018.
 */
public class VectorMath {

    public static double[] getVector(double[] origin, double[]destination) {

        double[] vector={destination[0]-origin[0],destination[1]-origin[1]};

        return normalizedVector(vector);


    }

    public static double[] normalizedVector(double[] vector){

            double h=Math.sqrt(Math.pow(vector[0],2)+Math.pow(vector[1],2));

            double normalizedVector[]= {vector[0]/h,vector[1]/h};

            return normalizedVector;



    }


}
