package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.bootcamp.GameEngine.FileManagement;
import org.academiadecodigo.bootcamp.Interfaces.Menuable;
import org.academiadecodigo.bootcamp.enums.SoundType;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Text;
import org.academiadecodigo.notsosimplegraphics.graphics.fonts;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

import java.io.File;

/**
 * Created by codecadet on 04/06/2018.
 */
public class GameOverMenu implements Menuable {
    private Picture background;
    private Picture gameOver;
    private Picture highScoreBoard;
    private Picture quitButton;
    private Picture youSuck;
    private Picture startButton;
    private Picture startPopUp;
    boolean onStartButton;
    boolean isVisible;
    private Text[] highScores;

    public GameOverMenu() {

        double[] SCREENDIMENTIONS = Canvas.getInstance().getScreenDimentions();


        System.out.println(SCREENDIMENTIONS[0] + " " + SCREENDIMENTIONS[1]);

        background = new Picture(20, -2, "Bgs/bg_gameover.png");

        background.scaleToFit(SCREENDIMENTIONS[0], SCREENDIMENTIONS[1]);

        highScoreBoard = new Picture(5, -20, "Bgs/gameover.png");


        startButton = new Picture(1808, 150, "Bgs/go2_small.png");

        quitButton = new Picture(1805, 20, "Bgs/Door-Closed.png");

        youSuck = new Picture(1808, 20, "Bgs/middlefinger.png");

        startPopUp = new Picture(1808, 150, "Bgs/go_small.png");

        highScores = new Text[5];

        highScores();
    }


    public int checkButtons(double[] mousePos) {

        int result = 0;

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
        background.draw();
        highScoreBoard.draw();
        startButton.draw();
        quitButton.draw();
        highScoreBoard.draw();

        for (Text text : highScores) {
            text.draw();
        }

        SoundType.GAMEOVER.playSound();

    }

    @Override
    public void hide() {
        background.delete();
        highScoreBoard.delete();
        quitButton.delete();
        youSuck.delete();
        startButton.delete();
        startPopUp.delete();
        for (Text text : highScores) {
            text.delete();
        }
        SoundType.GAMEOVER.stopSound();

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
            startPopUp.delete();
            startButton.draw();
            onStartButton = false;
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


    public void highScores() {


        FileManagement fileManagement = new FileManagement();
        String[] highScores = fileManagement.getHighScores();

        for (int i = 0; i < highScores.length; i++) {
            if (highScores[i] != null) {
                this.highScores[i] = new Text(1200, 800 + i * 30, highScores[i], fonts.SERIF,20);
                this.highScores[i].draw();
            }
        }
    }
}
