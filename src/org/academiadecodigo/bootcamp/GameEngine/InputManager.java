package org.academiadecodigo.bootcamp.GameEngine;


import org.academiadecodigo.notsosimplegraphics.keyboard.Keyboard;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.notsosimplegraphics.mouse.Mouse;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseEvent;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseEventType;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 02/06/2018.
 */
public class InputManager implements KeyboardHandler,MouseHandler {

    boolean goingRight;
    boolean goingLeft;
    boolean goingUp;
    boolean goingDown;
    boolean isFiring;

    double[] mousePos;

    public InputManager(){


        mousePos=new double[2];

        initControllers();

    }

    private void initControllers(){

        Keyboard keyboard = new Keyboard(this);

        //Adds listeners for the pressed and released events of keys W,A,S,D
        KeyboardEvent westDown = new KeyboardEvent();
        KeyboardEvent westUp = new KeyboardEvent();

        westDown.setKey(KeyboardEvent.KEY_A);
        westUp.setKey(KeyboardEvent.KEY_A);

        westUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        westDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(westUp);
        keyboard.addEventListener(westDown);


        KeyboardEvent northDown = new KeyboardEvent();
        KeyboardEvent northUp = new KeyboardEvent();

        northDown.setKey(KeyboardEvent.KEY_W);
        northUp.setKey(KeyboardEvent.KEY_W);

        northUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        northDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(northUp);
        keyboard.addEventListener(northDown);


        KeyboardEvent eastDown = new KeyboardEvent();
        KeyboardEvent eastUp = new KeyboardEvent();

        eastDown.setKey(KeyboardEvent.KEY_D);
        eastUp.setKey(KeyboardEvent.KEY_D);

        eastUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eastDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(eastUp);
        keyboard.addEventListener(eastDown);


        KeyboardEvent southDown = new KeyboardEvent();
        KeyboardEvent southUp = new KeyboardEvent();

        southDown.setKey(KeyboardEvent.KEY_S);
        southUp.setKey(KeyboardEvent.KEY_S);

        southUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        southDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(southUp);
        keyboard.addEventListener(southDown);

        //Same for mouse events
        Mouse mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    public void keyPressed(KeyboardEvent e){

        switch (e.getKey()){
            case KeyboardEvent.KEY_W:
                goingUp=true;
                break;
            case KeyboardEvent.KEY_D:
                goingRight=true;
                break;
            case KeyboardEvent.KEY_A:
                goingLeft=true;
                break;
            case KeyboardEvent.KEY_S:
                goingDown =true;
                break;
        }
    }

    public void keyReleased(KeyboardEvent e){

        switch (e.getKey()){
            case KeyboardEvent.KEY_W:
                goingUp=false;
                break;
            case KeyboardEvent.KEY_D:
                goingRight=false;
                break;
            case KeyboardEvent.KEY_A:
                goingLeft=false;
                break;
            case KeyboardEvent.KEY_S:
                goingDown =false;
                break;
        }
    }

    public boolean isFiring(){
        return isFiring;
    }

    public boolean[] getDirections(){

        boolean input[]= {goingUp,goingRight, goingDown,goingLeft};
        //System.out.println(goingDown + " " + goingUp + " " + goingLeft + " " + goingRight);
        return input;

    }

    public double[] getMousePos(){

        return mousePos;

    }

    public void mouseClicked(MouseEvent e) {


        isFiring=true;

    }

    public void mouseMoved(MouseEvent e){

        mousePos[0]=e.getX();
        mousePos[1]=e.getY();
        //System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
}
