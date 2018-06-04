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

        menuBackGround = new Picture(0, 0, "Bgs/SplashScreen2.jpg");
        menuBackGround.draw();

        startButton = new Picture(10, 40, "Bgs/video-play.png");
        startButton.draw();

        informationButton = new Picture(200, 700, "Bgs/info.jpg");
        informationButton.draw();



        /*if (inputManager.mouseClicked() == startButton.position) {
            game.init;
        }

        if(inputManager.mouseClicked() == informationButton.position) {
            informationPicture.show();
        }*/


    }


}
