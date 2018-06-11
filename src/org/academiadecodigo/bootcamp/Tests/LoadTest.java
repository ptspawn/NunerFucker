package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.Loader;
import org.academiadecodigo.bootcamp.MenuScreens.Pause;
import org.academiadecodigo.bootcamp.enums.CharactersType;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Created by codecadet on 07/06/2018.
 */
public class LoadTest {


    public static void main(String[] args) throws InterruptedException{



       Pause pause = new Pause();

       pause.show();

       while (true){

           pause.animate();
           Canvas.getInstance().repaint();
           Thread.sleep(20);
       }

    }

}
