package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.awt.*;

/**
 * Created by codecadet on 04/06/2018.
 */
public class MainMenu {

    private Picture informationButton;
    private Picture startButton;
    private Picture menuBackGround;
    private Rectangle rectangle;

    public MainMenu() {

        InputManager inputManager = new InputManager();

        double[]screenDimentions = Canvas.getInstance().getScreenDimentions();
        System.out.println(screenDimentions[0] + " " + screenDimentions[1]);

        menuBackGround = new Picture(0, 0, "Bgs/SplashScreen2_1920.jpg");
        //menuBackGround.scaleToFit(screenDimentions[0],screenDimentions[1]);

        menuBackGround.draw();

        startButton = new Picture(1100, 250, "Bgs/video-play.png");
        startButton.draw();

        informationButton = new Picture(1162, 600, "Bgs/icon-i.png");
        informationButton.draw();


/*
        if (inputManager.getMousePos() == startButton.getX() && startButton.getY()
                && startButton.getHeight() && startButton.getWidth()){
            ;
        }

        if(inputManager.mouseClicked() == informationButton.position) {
            informationButton.show();
        }
*/

    }


}
