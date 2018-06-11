package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.bootcamp.GameEngine.Collider;
import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.notsosimplegraphics.graphics.*;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 06/06/2018.
 */
public class Hud {

    private Picture cannabis;
    private Picture heart;
    private Rectangle powerUp;
    private Rectangle life;
    private Text textScore;


    private int lifeMax = 250;
    private int weedMax = 250;
    private int currentWeed = 1;
    private int score;

    public Hud() {

        double[] screenDimentions = Game.SCREENDIMENTIONS;

        life = new Rectangle(30, 20, 1, 25); //max width 250
        life.setColor(Color.RED);

        powerUp = new Rectangle(1640, 20, 1, 25); //max width 250
        powerUp.setColor(Color.GREEN);

        heart = new Picture(13, 5, "Bgs/heart.png");

        cannabis = new Picture(1610, -3, "Bgs/powerup.png");

        textScore = new Text(screenDimentions[0] / 2 - 190, 10, "BLOOD SPILT - " + score, fonts.SERIF, 40);
        textScore.setColor(Color.LIGHT_GRAY);
    }

    public void setLife(int life) {

        this.life.setDimentions( (life / 1000 )* lifeMax, 25);
        System.out.println(life);
        System.out.println("teoric width" + life / 1000 * lifeMax);
        System.out.println("width" + this.life.getWidth());

    }

    public boolean increaseCurrentWeed(int weedIncrement) {

        if (this.currentWeed == 100) {
            return true;
        }

        this.currentWeed += weedIncrement;
        if (this.currentWeed > 100) {
            this.currentWeed = 100;
        }

        this.powerUp.setDimentions(currentWeed / 100 * weedMax, 25);
        return false;
    }

    public void resetWeed() {
        currentWeed = 1;
    }

    // SCORE

    public void incrementScore(int score) {
        textScore.setText("BLOOD SPILT - " + score);
    }

    public void showHud() {
        life.draw();
        life.fill();
        powerUp.draw();
        powerUp.fill();
        heart.draw();
        cannabis.draw();
        textScore.draw();
    }

    public void hideHud() {

        cannabis.delete();
        heart.delete();
        powerUp.delete();
        life.delete();
        textScore.delete();
        textScore.draw();
    }

}
