package org.academiadecodigo.bootcamp.Field;

import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Field implements Drawable{

    private Picture bg;
    private Rectangle base;
    private Mouse mouse;

    public Field(String imageSource){


        bg=new Picture(10,10,"Bgs/bg.jpg");
        bg.draw();

    }

    public void draw(){

        bg.draw();

    }

    public void preLoadGraphics(){



    }



    public double getWidth(){
        return bg.getWidth();
    }

    public double getHeight(){
        return bg.getHeight();
    }

}
