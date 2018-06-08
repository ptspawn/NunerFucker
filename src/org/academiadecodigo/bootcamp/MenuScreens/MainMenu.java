package org.academiadecodigo.bootcamp.MenuScreens;

import javafx.scene.input.MouseDragEvent;
import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.Sound.Sound;
import org.academiadecodigo.notsosimplegraphics.graphics.*;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Color;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.notsosimplegraphics.mouse.Mouse;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseEvent;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseEventType;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseHandler;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Created by codecadet on 04/06/2018.
 */
public class MainMenu {

    private Picture title2;
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

        double[] screenDimentions = Game.SCREENDIMENTIONS;

        menuBackGround = new Picture(0, 0, "Bgs/SplashScreen2_1920.jpg");

//        menuBackGround.scaleToFit(screenDimentions[0], screenDimentions[1]);
        menuBackGround.draw();

        startButton = new Picture(1100, 410, "Bgs/video-play.png");
        startButton.draw();

        startPopUp = new Picture(1100, 410, "Bgs/2c_go.png");

        informationButton = new Picture(1805, 850, "Bgs/question.png");
        informationButton.draw();

        quitButton = new Picture(1805, 20, "Bgs/Door-Closed.png");
        quitButton.draw();

        title = new Picture(800, 190, "Bgs/NUNS.png");
        title.draw();

        title2 = new Picture(1280, 210, "Bgs/ng.png");
        title2.draw();

        instrutionPanel = new Picture(1000, 35, "Bgs/instructions.png");

        youSuck = new Picture(1808, 20, "Bgs/middlefinger.png");
    }

    public int checkButtons(double[] mousePos) {

        int result = 0;

        if(checkStartButton(mousePos)){
            result=1;
        }
        if(quiting(mousePos)){
            result=2;
        }

        return result;

    }

    private boolean checkStartButton(double[] mousePos) {

        if (mousePos[0] > startButton.getX()
                && mousePos[0] < startButton.getX() + startButton.getWidth()
                && mousePos[1] > startButton.getY()
                && mousePos[1] < startButton.getY() + startButton.getHeight()) {

            startButton.delete();
            startPopUp.draw();
            onStartButton = true;
            return true;

        } else {
            if (!onInstructionButton) {
                startButton.draw();
            }
            startPopUp.delete();
            onStartButton = false;
            return false;

        }
    }

    private boolean instructionsSlide(double[] mousePos) {

        if (mousePos[0] > informationButton.getX()
                && mousePos[0] < informationButton.getX() + informationButton.getWidth()
                && mousePos[1] > informationButton.getY()
                && mousePos[1] < informationButton.getY() + informationButton.getHeight()) {

            title2.delete();
            title.delete();
            quitButton.delete();
            startButton.delete();
            informationButton.delete();
            instrutionPanel.draw();
            onInstructionButton = true;
            return true;

        } else {
            if (!onStartButton) {
                startButton.draw();
            }
            quitButton.draw();
            title2.draw();
            title.draw();
            instrutionPanel.delete();
            informationButton.draw();
            onInstructionButton = false;
            return false;
        }
    }

    private boolean quiting(double[] mousePos) {

        if (mousePos[0] > quitButton.getX()
                && mousePos[0] < quitButton.getX() + quitButton.getWidth()
                && mousePos[1] > quitButton.getY()
                && mousePos[1] < quitButton.getY() + quitButton.getHeight()) {

            quitButton.delete();
            youSuck.draw();
            return true;

        } else {
            youSuck.delete();
            quitButton.draw();
            return false;
        }
    }
}




