package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.MenuScreens.Score;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2018.
 */
public class ScoreTest {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();

        Picture picture= new Picture(0, 0, "Bgs/bg_fullhd.jpg");
        picture.draw();

        Score score = new Score();
        score.incrementScore(100);

        Canvas.getInstance().repaint();
    }
}
