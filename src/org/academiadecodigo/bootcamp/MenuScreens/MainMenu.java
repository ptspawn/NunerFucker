package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.Interfaces.Menuable;
import org.academiadecodigo.bootcamp.enums.SoundType;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public class MainMenu implements Menuable {

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
    boolean isVisible;

    public MainMenu() {
        double[] screenDimentions = Game.SCREENDIMENTIONS;

        menuBackGround = new Picture(0, 0, "resources/Bgs/SplashScreen2_1920.jpg");

        menuBackGround.scaleToFit(screenDimentions[0], screenDimentions[1]);

        startButton = new Picture(1100, 410, "resources/Bgs/video-play.png");

        startPopUp = new Picture(1100, 410, "resources/Bgs/2c_go.png");

        informationButton = new Picture(1805, 850, "resources/Bgs/question.png");

        quitButton = new Picture(1805, 20, "resources/Bgs/Door-Closed.png");

        title = new Picture(800, 190, "resources/Bgs/NUNS.png");

        title2 = new Picture(1280, 210, "resources/Bgs/ng.png");

        instrutionPanel = new Picture(1000, 35, "resources/Bgs/instructions.png");

        youSuck = new Picture(1808, 20, "resources/Bgs/middlefinger.png");

    }

    public int checkButtons(double[] mousePos) {

        int result = 0;

        instructionsSlide(mousePos);

        if (checkStartButton(mousePos)) {
            result = 1;
        }
        if (quiting(mousePos)) {
            result = 2;
        }


        return result;

    }

    @Override
    public void show() {
        isVisible = true;
        menuBackGround.draw();
        startButton.draw();
        informationButton.draw();
        quitButton.draw();
        title.draw();
        title2.draw();
        SoundType.MENU.playSound();
    }

    @Override
    public void hide() {
        isVisible = false;
        title2.delete();
        startPopUp.delete();
        quitButton.delete();
        instrutionPanel.delete();
        informationButton.delete();
        startButton.delete();
        menuBackGround.delete();
        youSuck.delete();
        title.delete();
        SoundType.MENU.stopSound();
    }

    private boolean checkStartButton(double[] mousePos) {

        if (!isVisible) {
            return false;
        }

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

        if (!isVisible) {
            return false;
        }

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

        if (!isVisible) {
            return false;
        }

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




