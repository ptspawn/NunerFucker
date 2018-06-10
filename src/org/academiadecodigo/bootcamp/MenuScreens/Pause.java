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

    private Picture[] bNun;
    private Picture[] pNun;
    private int[] animCounter;

    private final int nunQty = 3;

    public Pause() {

        screenDimentions = Game.SCREENDIMENTIONS;
        pauseText = new Text(screenDimentions[0] / 2, screenDimentions[1] / 2, "Game Paused", fonts.SERIF);
        purpleNun = new Picture[4];
        blackNun = new Picture[4];
        bNun = new Picture[nunQty];
        pNun = new Picture[nunQty];
        animCounter=new int[nunQty];


        for (int i = 0; i < 4; i++) {

            blackNun[i] = new Picture(0, 0, "avatar/Sprites/blackNun" + i + 1 + ".png");
            purpleNun[i] = new Picture(0, 0, "avatar/Sprites/blackNun" + i + 1 + ".png");

        }

        for (int i = 0; i < nunQty; i++) {

            animCounter[i]=(int) (Math.random() * blackNun.length);

            bNun[i] = new Picture((int)(Math.random()*screenDimentions[0]), , blackNun[animCounter[i]].getImage());
            pNun[i] = new Picture(0, 0, purpleNun[animCounter[i]].getImage());

        }

    }

    public void animate() {

        for (int i = 0; i < nunQty; i++) {



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
