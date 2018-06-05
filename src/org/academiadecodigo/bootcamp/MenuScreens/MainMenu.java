package org.academiadecodigo.bootcamp.MenuScreens;

import javafx.scene.input.MouseDragEvent;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.notsosimplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.notsosimplegraphics.mouse.Mouse;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseEvent;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseEventType;
import org.academiadecodigo.notsosimplegraphics.mouse.MouseHandler;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.awt.*;

/**
 * Created by codecadet on 04/06/2018.
 */
public class MainMenu implements MouseHandler {

    private Picture loading;
    private Picture informationButton;
    private Picture startButton;
    private Picture menuBackGround;
    private Rectangle rectangle;
    private Mouse mouse;
    private Point point;


    public MainMenu() {

        InputManager inputManager = new InputManager();

        double[] screenDimentions = Canvas.getInstance().getScreenDimentions();
        //System.out.println(screenDimentions[0] + " " + screenDimentions[1]);

        menuBackGround = new Picture(0, 0, "Bgs/SplashScreen2_1920.jpg");
        //menuBackGround.scaleToFit(screenDimentions[0],screenDimentions[1]);

        menuBackGround.draw();

        startButton = new Picture(1100, 250, "Bgs/video-play.png");
        startButton.draw();

        informationButton = new Picture(1805, 900, "Bgs/question.png");
        informationButton.draw();

        double[] mousePos = inputManager.getMousePos();


               if (mousePos[0] > startButton.getX()
                && mousePos[0] < startButton.getX() + startButton.getWidth()
                && mousePos[1] > startButton.getY()
                && mousePos[1] < startButton.getY() + startButton.getHeight()) {

                   startButton.load("Bgs/2c_go.png");
                   startButton.draw();

        }

        //if(inputManager.mouseClicked(MouseDragEvent) == startButton.getWidth() &&
        // startButton.getHeight() && startButton.getX() && startButton) {
        // loading = new Picture(0,0, );
        //}
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
}
