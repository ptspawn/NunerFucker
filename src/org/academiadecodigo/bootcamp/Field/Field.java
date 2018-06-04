package org.academiadecodigo.bootcamp.Field;

import org.academiadecodigo.bootcamp.Interfaces.Drawable;
import org.academiadecodigo.notsosimplegraphics.graphics.Rectangle;
import org.academiadecodigo.notsosimplegraphics.mouse.Mouse;
import org.academiadecodigo.notsosimplegraphics.pictures.Picture;


/**
 * Created by codecadet on 02/06/2018.
 */
public class Ft ield implements Drawable{

    private Picture bg;
    private Rectangle base;
    private Mouse mouse;

    public Field(String imageSource){


        bg=new Picture(0,0,"Bgs/bg.jpg");
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
