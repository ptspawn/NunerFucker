package org.academiadecodigo.bootcamp.Tests;
import org.academiadecodigo.bootcamp.GameEngine.InputManager;
import org.academiadecodigo.bootcamp.MenuScreens.Hud;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

/**
 * Created by codecadet on 06/06/2018.
 */
public class HudTest {

    public static void main(String[] args) throws InterruptedException {

        Canvas.getInstance().repaint();

        InputManager inputManager = new InputManager();
        Hud hud = new Hud();

        hud.getHud();
    }
}
