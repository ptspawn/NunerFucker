package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameEngine.Loader;
import org.academiadecodigo.bootcamp.Interfaces.CharactersType;
import org.academiadecodigo.notsosimplegraphics.graphics.Canvas;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Created by codecadet on 07/06/2018.
 */
public class LoadTest {

    private Map<CharactersType,BufferedImage> enemies;

    public LoadTest(){

        Loader loader=new Loader();

        loader.loadPictureList(enemies);

        Canvas.getInstance().getScreenDimentions();



    }

}
