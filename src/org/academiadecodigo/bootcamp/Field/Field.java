package org.academiadecodigo.bootcamp.Field;

import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.image.BufferedImage;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Field implements Drawable{

    private Picture bg;

    public Field(String imageSource){

        bg=new Picture(10,10,"bg.jpg");
        preLoadGraphics();


    }

    public void draw(){

        bg.draw();

    }

    public void preLoadGraphics(){



    }

}
