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

    private int frameCounter=20;
    private int frameRate=20;

    private final int nunQty = 3;

    public Pause() {

        screenDimentions = Canvas.getInstance().getScreenDimentions();//Game.SCREENDIMENTIONS;
        pauseText = new Text(screenDimentions[0] / 2, screenDimentions[1] / 2, "Game Paused", fonts.SERIF,20);
        purpleNun = new Picture[4];
        blackNun = new Picture[4];
        bNun = new Picture[nunQty];
        pNun = new Picture[nunQty];
        animCounter=new int[nunQty];


        for (int i = 0; i < 4; i++) {

            blackNun[i] = new Picture(-100, -100, "avatar/Sprites/blackNun" + (i + 1) + ".png");
            purpleNun[i] = new Picture(-100, -100, "avatar/Sprites/blackNun" + (i + 1) + ".png");
            System.out.println("Instantiated pictures " + i);

        }

        for (int i = 0; i < nunQty; i++) {

            animCounter[i]=(int) (Math.random() * blackNun.length);

            bNun[i] = new Picture((int)(Math.random()*screenDimentions[0]), (int)(Math.random()*(-100)), blackNun[animCounter[i]].getImage());
            pNun[i] = new Picture((int)(Math.random()*screenDimentions[0]), (int)(Math.random()*(-100)), purpleNun[animCounter[i]].getImage());

            System.out.println("drawn pictures " + i);

        }

    }

    public void animate() {

        for (int i = 0; i < nunQty; i++) {

            if (frameCounter++ == frameRate) {

                bNun[i].translate(0,-10);
                pNun[i].translate(0,-20);

                frameCounter=0;

            }

        }



    }

    public void show() {

        pauseText.draw();

        for (int i = 0; i < nunQty; i++) {


            bNun[i].draw();
            pNun[i].draw();
            System.out.println("drawn pictures " + i);

        }

        SoundType.ELEVATOR.playSound();

    }

    public void hide() {
        SoundType.ELEVATOR.stopSound();

        for (int i = 0; i < nunQty; i++) {


            bNun[i].delete();
            pNun[i].delete();
            System.out.println("drawn pictures " + i);

        }
        pauseText.delete();
    }


}
