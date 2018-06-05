package org.academiadecodigo.bootcamp.Sound;

import sun.audio.*;
import  java.io.*;

public class Sound {

    public static void playBackground(){

        try {
            InputStream in = new FileInputStream("Resources/Sounds/background.wav");
            AudioStream as = new AudioStream(in);

            AudioData data = as.getData();
            ContinuousAudioDataStream audioStream = new ContinuousAudioDataStream(data);

            AudioPlayer.player.start(audioStream);

        } catch (Exception e){
            System.out.println("Audio doesn't work");
        }
    }

    public static void playGun(){
        try {
            InputStream in = new FileInputStream("Resources/Sounds/gun.wav");
            AudioStream as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e){
            System.out.println("Audio doesn't work");
        }
    }

    public static void playPunch(){
        try {
            InputStream in = new FileInputStream("Resources/Sounds/punch.wav");
            AudioStream as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e){
            System.out.println("Audio doesn't work");
        }
    }
}
