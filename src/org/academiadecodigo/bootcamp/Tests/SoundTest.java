package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.enums.SoundType;


public class SoundTest {

    public static void main(String[] args) throws Exception{
        SoundType menu = SoundType.MENU;
        menu.playSound();

        /*while (true){
            Thread.sleep(500);
            SoundType.ROCKET.playSound();
        }*/
        Thread.sleep(5000);
        menu.stopSound();

    }

}
