package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Color;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 06/06/2018.
 */
public class Hud {

    private Rectangle rect;
    private Picture heart;

    public Hud() {

        double[] screenDimentions = Canvas.getInstance().getScreenDimentions();

        rect = new Rectangle(1100, 0, 1100, 0);

        heart = new Picture(1100, 0, "Power-ups/PNG/heart.png");
    }

    public void getHud() {

        heart.draw();
        rect.draw();
        rect.fill();
        rect.setColor(Color.BLACK);
    }
}
