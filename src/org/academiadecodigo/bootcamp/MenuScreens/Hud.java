package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.bootcamp.GameEngine.Collider;
import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Color;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 06/06/2018.
 */
public class Hud {

    private Picture cannabis;
    private Picture heart;
    private Rectangle powerUp;
    private Rectangle life;

    private int lifeMax=250;
    private int weedMax=250;

    public Hud() {

        double[] screenDimentions = Game.SCREENDIMENTIONS;

        life = new Rectangle(30, 20, 1, 25);
        powerUp = new Rectangle(1640, 20, 1, 25);

        heart = new Picture(13, 5, "Bgs/heart.png");
        cannabis = new Picture(1610, -3, "Bgs/powerup.png");

        life.draw();
        life.fill();
        life.setColor(Color.RED);
        powerUp.draw();
        powerUp.fill();
        powerUp.setColor(Color.GREEN);
        heart.draw();
        cannabis.draw();

    }

    public void setLife(int life) {

        int currentWidth=this.life.getWidth();

        this.life.grow(life/100*lifeMax,0);

    }
}
