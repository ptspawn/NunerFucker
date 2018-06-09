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


    public GameOverMenu() {

        double[] SCREENDIMENTIONS = Canvas.getInstance().getScreenDimentions();


        System.out.println(SCREENDIMENTIONS[0] + " " + SCREENDIMENTIONS[1]);


        background = new Picture(0, 0, "Bgs/bg_gameover.png");
        background.scaleToFit(SCREENDIMENTIONS[0], SCREENDIMENTIONS[1]);
        background.draw();

        gameOver = new Picture(20, 860, "Bgs/gameover.png");
        gameOver.draw();

        highScoreBoard = new Picture(1080, SCREENDIMENTIONS[1] - 961, "Bgs/highscore.png");
        highScoreBoard.draw();

        highScores();

        Canvas.getInstance().repaint();

    }


    public void highScores() {

        FileManagement fileManagement = new FileManagement();
        String[] highScores = fileManagement.getHighScores();

        for (int i = 0; i <highScores.length; i++) {
            if (highScores[i] != null) {
                Text text = new Text(1300, 480 + i * 30, highScores[i]);
                text.draw();
            }
        }

    }
}
