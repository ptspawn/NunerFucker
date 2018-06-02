package org.academiadecodigo.bootcamp.Characters;

import org.academiadecodigo.bootcamp.Interfaces.Direction;
import org.academiadecodigo.bootcamp.Interfaces.Movable;

/**
 * Created by codecadet on 02/06/2018.
 */
public abstract class Character implements Movable{

    private int health;
    private int speed;

    private Direction direction;

    public void setDirection(Direction direction){

        this.direction=direction;

    }

}
