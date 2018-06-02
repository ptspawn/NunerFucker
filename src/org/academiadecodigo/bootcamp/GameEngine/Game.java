package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Field.Field;

import java.awt.*;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Game {

    Field field;
    private List enemies;
    private List projectiles;
    private Player player;


    public Game(){

        field=new Field("bg.jpg");

    }
}
