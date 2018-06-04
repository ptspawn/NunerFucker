package org.academiadecodigo.bootcamp.MenuScreens;

import jdk.internal.util.xml.impl.Input;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

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

        menuBackGround = new Picture(0, 0, "Bgs/SplashScreen2_1920.jpg");
        menuBackGround.draw();

        startButton = new Picture(1100, 250, "Bgs/video-play.png");
        startButton.draw();

        informationButton = new Picture(1162, 600, "Bgs/icon-i.png");
        informationButton.draw();



        if (inputManager.getMousePos() == startButton.getX() && startButton.getY()
                && startButton.getHeight() && startButton.getWidth()){
            ;
        }

        if(inputManager.mouseClicked() == informationButton.position) {
            informationButton.show();
        }


    }


}
