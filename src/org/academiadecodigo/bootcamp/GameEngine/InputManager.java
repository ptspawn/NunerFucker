package org.academiadecodigo.bootcamp.GameEngine;

import org.academiadecodigo.bootcamp.Characters.Player;
import org.academiadecodigo.bootcamp.Characters.pTest;
import org.academiadecodigo.bootcamp.Field.Field;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;


/**
 * Created by codecadet on 02/06/2018.
 */
public class InputManager implements KeyboardHandler,MouseHandler {

    pTest player;

    Keyboard keyboard;
    Mouse mouse;
    Hud hud;
    Field field;

    public InputManager(pTest player, Hud hud, Field field){

        this.player=player;
        this.hud=hud;
        this.field=field;

        initControllers();

    }

    private void initControllers(){

        keyboard = new Keyboard(this);


        KeyboardEvent west = new KeyboardEvent();

        west.setKey(KeyboardEvent.KEY_LEFT);

        west.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        west.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(west);


        KeyboardEvent east = new KeyboardEvent();

        east.setKey(KeyboardEvent.KEY_RIGHT);

        east.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        east.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(east);


        KeyboardEvent north = new KeyboardEvent();

        north.setKey(KeyboardEvent.KEY_UP);

        north.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        north.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(north);


        KeyboardEvent south = new KeyboardEvent();

        south.setKey(KeyboardEvent.KEY_DOWN);

        south.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        south.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(south);


        mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    public void keyPressed(KeyboardEvent e){

        player.shoot();

    }

    public void keyReleased(KeyboardEvent e){

        player.shoot();

    }

    public void getMousePos(){


    }

    public void mouseClicked(MouseEvent e) {

        System.out.println(e);

    }

    public void mouseMoved(MouseEvent e){

        System.out.println(e.getX() + " " + e.getY());

    }



}
