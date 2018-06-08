package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Color;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 06/06/2018.
 */
public class Hud {

    private Picture hudBackGround;
    private Picture heart;
    private Rectangle powerUp;
    private Rectangle life;

    public Hud() {

        double[] screenDimentions = Canvas.getInstance().getScreenDimentions();

        hudBackGround = new Picture(100,0, "Bgs/hubBackGround.png");

        life = new Rectangle(870, 15, 250, 25);
        //powerUp = new Rectangle(870, 40, 250, 25);

        heart = new Picture(830, 0, "Bgs/heart.png");
    }

    public void getHud() {

        hudBackGround.draw();
        life.draw();
        life.fill();
        life.setColor(Color.RED);
        heart.draw();

      /*  powerUp.draw();
        powerUp.fill();
        powerUp.setColor(Color.GREEN); */




    }
}
