package org.academiadecodigo.bootcamp.Tests;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.MenuScreens.Hud;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

/**
 * Created by codecadet on 06/06/2018.
 */
public class HudTest {

    public static void main(String[] args) throws InterruptedException {



        InputManager inputManager = new InputManager();
        Hud hud = new Hud();

        Canvas.getInstance().repaint();
    }
}
