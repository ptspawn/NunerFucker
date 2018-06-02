package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Characters.pTest;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.List;


/**
 * Created by codecadet on 02/06/2018.
 */
public class Game {

    private Field field;
    private List enemies;
    private List projectiles;
    private pTest player;


    public void Game(){




        field=new Field("bg.jpg");
        pTest player = new pTest();


    }

    public void start(){



    }
}
