package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.enums.PlayerVoiceType;
import org.academiadecodigo.bootcamp.enums.SoundType;


public class SoundTest {

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < PlayerVoiceType.values().length; i++) {
            System.out.println(i);
            PlayerVoiceType.values()[i].playSound();

            
        }


        /*while (true){
            Thread.sleep(500);
            SoundType.ROCKET.playSound();
        }*/
        PlayerVoiceType.AAAAHHH.playSound();



    }
}
