package org.academiadecodigo.bootcamp.MenuScreens;

import javafx.scene.input.MouseDragEvent;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.Sound.Sound;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.notsosimplegraphics.mouse.Mouse;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseEvent;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseEventType;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseHandler;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Created by codecadet on 04/06/2018.
 */
public class MainMenu {

    private Sound mouseClick;
    private Picture quitButton;
    private Picture instrutionPanel;
    private Picture informationButton;
    private Picture startButton;
    private Picture menuBackGround;
    private MouseEventType[] mouseEventType;


    public MainMenu() {

        double[] screenDimentions = Canvas.getInstance().getScreenDimentions();

        mouseClick = new Sound();


        menuBackGround = new Picture(0, 0, "Bgs/SplashScreen2_1920.jpg");
        //menuBackGround.scaleToFit(screenDimentions[0],screenDimentions[1]);
        menuBackGround.draw();

        startButton = new Picture(1100, 250, "Bgs/video-play.png");
        startButton.draw();

        informationButton = new Picture(1805, 800, "Bgs/question.png");
        informationButton.draw();

        instrutionPanel = new Picture(1000, 35, "Bgd/instP.jpg");

        quitButton = new Picture(1175, 555, "Bgs/door.png");
        quitButton.draw();

    }

    public void checkButton(double[] mousePos) {

        if (mousePos[0] > startButton.getX()
                && mousePos[0] < startButton.getX() + startButton.getWidth()
                && mousePos[1] > startButton.getY()
                && mousePos[1] < startButton.getY() + startButton.getHeight()) {

            startButton.load("Bgs/2c_go.png");
            startButton.draw();
            Canvas.getInstance().repaint();

        } else {
            startButton.load("Bgs/video-play.png");
            startButton.draw();
            Canvas.getInstance().repaint();

        }
    }

    public void instructionsSlide(double[] mousePos) {

        if (mousePos[0] > informationButton.getX()
                && mousePos[0] < informationButton.getX() + informationButton.getWidth()
                && mousePos[1] > informationButton.getY()
                && mousePos[1] < informationButton.getY() + informationButton.getHeight()) {

            startButton.delete();
            informationButton.delete();
            instrutionPanel.load("Bgs/instP.jpg");
            instrutionPanel.draw();
            Canvas.getInstance().repaint();

        } else {
            instrutionPanel.delete();
            informationButton.load("Bgs/question.png");
            informationButton.draw();
            Canvas.getInstance().repaint();

        }
    }
}



