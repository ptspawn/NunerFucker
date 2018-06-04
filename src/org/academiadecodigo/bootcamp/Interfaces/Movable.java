package org.academiadecodigo.bootcamp.Interfaces;

/**
 * Created by codecadet on 02/06/2018.
 */
public interface Movable {

    void move(double[] vector) throws InterruptedException;

    void move(boolean[] directions, double[] orientation);

    void setDirection(double[] vector);

}
