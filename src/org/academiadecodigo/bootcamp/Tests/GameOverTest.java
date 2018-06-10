package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.MenuScreens.GameOverMenu;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

/**
 * Created by codecadet on 09/06/2018.
 */
public class GameOverTest {

    public static void main(String[] args) {
        InputManager input = new InputManager();
        GameOverMenu gameOverMenu = new GameOverMenu();
        double[] mousePosition;
        gameOverMenu.show();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameOverMenu.hide();

        while (true) {

            mousePosition = input.getMousePos();
            int result = 0;

            if ((result = gameOverMenu.checkButtons(mousePosition)) != 0 && input.isFiring()) {

                switch (result) {

                    case 1:
                        //        start();
                    case 2:
                        System.exit(0);

                }

            }

            Canvas.getInstance().repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Ups");
            }

        }

    }
}
