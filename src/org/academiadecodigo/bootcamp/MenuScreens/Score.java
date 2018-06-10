package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.notsosimplegraphics.graphics.*;


/**
 * Created by codecadet on 10/06/2018.
 */
public class Score {

    private Rectangle scoreBar;
    private int score;
    private Text text;


    public Score(){

        double[] screenDimentions = Canvas.getInstance().getScreenDimentions();
        score=9999;
        text=new Text (screenDimentions[0]/2 -190, 10, "BLOOD SPILT - " +score, fonts.SERIF,40 );
        text.setColor(Color.LIGHT_GRAY);
        text.draw();

        Canvas.getInstance().repaint();
        System.out.println(""+text.getWidth());

    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int score) {

        this.score += score;
    }
}
