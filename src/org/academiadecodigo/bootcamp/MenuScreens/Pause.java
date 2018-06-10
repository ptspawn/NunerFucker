package org.academiadecodigo.bootcamp.MenuScreens;

import org.academiadecodigo.bootcamp.GameEngine.Game;
import org.academiadecodigo.bootcamp.Sound.Sound;
import org.academiadecodigo.bootcamp.enums.SoundType;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;
import org.academiadecodigo.notsosimplegraphics.graphics.Text;
import org.academiadecodigo.notsosimplegraphics.graphics.fonts;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2018.
 */
public class Pause {

    private Text pauseText;
    private double[] screenDimentions;
    private Picture[] blackNun;
    private Picture[] purpleNun;


    public Pause() {

        screenDimentions = Canvas.getInstance().getScreenDimentions();//Game.SCREENDIMENTIONS;
        pauseText = new Text(screenDimentions[0] / 2, screenDimentions[1] / 2, "Game Paused", fonts.SERIF);
        purpleNun = new Picture[4];
        blackNun = new Picture[4];


        for (int i = 0; i < 4; i++) {



        }
    }

    public void show() {

        pauseText.draw();
        SoundType.ELEVATOR.playSound();

    }

    public void hide() {
        SoundType.ELEVATOR.stopSound();
        pauseText.delete();
    }


}
