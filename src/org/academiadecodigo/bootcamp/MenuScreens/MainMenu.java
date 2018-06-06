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

    private Picture startPopUp;
    private Picture quitButton;
    private Picture instrutionPanel;
    private Picture informationButton;
    private Picture startButton;
    private Picture menuBackGround;
    private Picture youSuck;
    private Picture title;

    boolean onStartButton;
    boolean onInstructionButton;

    public MainMenu() {

        double[] screenDimentions = Canvas.getInstance().getScreenDimentions();

        menuBackGround = new Picture(0, 0, "Bgs/SplashScreen2_1920.jpg");

        menuBackGround.scaleToFit(screenDimentions[0], screenDimentions[1]);
        menuBackGround.draw();

        startButton = new Picture(1100 / 1920 * screenDimentions[0], 350 / 1080 * screenDimentions[1], "Bgs/video-play.png");
        startButton.draw();

        startPopUp = new Picture(1100 / 1920 * screenDimentions[0], 350 / 1080 * screenDimentions[1], "Bgs/2c_go.png");


        informationButton = new Picture(1805 / 1920 * screenDimentions[0], 850 / 1080 * screenDimentions[1], "Bgs/question.png");
        informationButton.draw();

        quitButton = new Picture(1805 / 1920 * screenDimentions[0], 20 / 1080 * screenDimentions[1], "Bgs/Door-Closed.png");
        quitButton.draw();

        //title = new Picture(1100, 100, "Bgs/rosary.jpg");
        //title.draw();

        instrutionPanel = new Picture(1000 / 1920 * screenDimentions[0], 35 / 1080 * screenDimentions[1], "Bgs/instructions.png");

        youSuck = new Picture(1808 / 1920 * screenDimentions[0], 20 / 1080 * screenDimentions[1], "Bgs/middlefinger.png");
    }

    public void checkButton(double[] mousePos) {

        if (mousePos[0] > startButton.getX()
                && mousePos[0] < startButton.getX() + startButton.getWidth()
                && mousePos[1] > startButton.getY()
                && mousePos[1] < startButton.getY() + startButton.getHeight()) {

            startButton.delete();
            startPopUp.draw();
            onStartButton = true;

        } else {
            if (!onInstructionButton) {
                startButton.draw();
            }
            startPopUp.delete();
            onStartButton = false;

        }
    }

    public void instructionsSlide(double[] mousePos) {

        if (mousePos[0] > informationButton.getX()
                && mousePos[0] < informationButton.getX() + informationButton.getWidth()
                && mousePos[1] > informationButton.getY()
                && mousePos[1] < informationButton.getY() + informationButton.getHeight()) {

            quitButton.delete();
            startButton.delete();
            informationButton.delete();
            instrutionPanel.draw();
            onInstructionButton = true;

        } else {
            if (!onStartButton) {
                startButton.draw();
            }
            quitButton.draw();
            instrutionPanel.delete();
            informationButton.draw();
            onInstructionButton = false;

        }
    }

    public void quiting(double[] mousePos) {

        if (mousePos[0] > quitButton.getX()
                && mousePos[0] < quitButton.getX() + quitButton.getWidth()
                && mousePos[1] > quitButton.getY()
                && mousePos[1] < quitButton.getY() + quitButton.getHeight()) {

            quitButton.delete();
            youSuck.draw();

        } else {
            youSuck.delete();
            quitButton.draw();

        }
    }
}




