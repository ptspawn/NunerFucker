package org.academiadecodigo.bootcamp.GameEngine;


import org.academiadecodigo.notsosimplegraphics.graphics.Text;

/**
 * Created by codecadet on 02/06/2018.
 */
public class Hud {

    private Text health;

    public Hud(){

        health = new Text(10,10,"This is a test");
        health.draw();

    }

    public void writeToHud(String text){

        health.setText(text);
        health.draw();

    }




}
