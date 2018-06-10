package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.bootcamp.GameEngine.FileManagement;
import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Color;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;
import org.academiadecodigo.notsosimplegraphics.graphics.Text;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

import java.io.File;

/**
 * Created by codecadet on 04/06/2018.
 */
public class GameOverMenu {
    private Picture background;
    private Picture gameOver;
    private Picture highScoreBoard;
    private Picture quitButton;
    private Picture youSuck;
    private Picture startButton;
    private Picture startPopUp;
    boolean onStartButton;

    public GameOverMenu() {

        double[] SCREENDIMENTIONS = Canvas.getInstance().getScreenDimentions();

        Rectangle rectangle = new Rectangle(0, 0, SCREENDIMENTIONS[0], SCREENDIMENTIONS[1]);
        rectangle.setColor(Color.BLACK);
        rectangle.fill();

        System.out.println(SCREENDIMENTIONS[0] + " " + SCREENDIMENTIONS[1]);

        background = new Picture(0, -100, "Bgs/bg_gameover.png");
        background.scaleToFit(SCREENDIMENTIONS[0], SCREENDIMENTIONS[1]);
        background.draw();

        gameOver = new Picture(20, SCREENDIMENTIONS[1] - 150, "Bgs/gameover.png");
        gameOver.draw();

        highScoreBoard = new Picture(0, 0, "Bgs/grava.png");
        highScoreBoard.draw();

        startButton = new Picture(1808, 150, "Bgs/go2_small.png");

        startButton.draw();
        quitButton = new Picture(1805, 20, "Bgs/Door-Closed.png");

        quitButton.draw();
        youSuck = new Picture(1808, 20, "Bgs/middlefinger.png");

        startPopUp = new Picture(1808, 150, "Bgs/go_small.png");

        highScores();

        Canvas.getInstance().repaint();

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
                Text text = new Text(110, 100 + i * 30, highScores[i]);
                text.draw();
            }
        }

    }
}
