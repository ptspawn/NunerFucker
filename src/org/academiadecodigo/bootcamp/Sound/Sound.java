package org.academiadecodigo.bootcamp.Sound;

import sun.audio.*;
import  java.io.*;

public class Sound {

    public static void playBackground(){

        try {
            InputStream in = new FileInputStream("Resources/Sounds/Drum.wav");
            AudioStream as = new AudioStream(in);
            AudioData data = as.getData();
            ContinuousAudioDataStream audioStream = new ContinuousAudioDataStream(data);
            //while (true){
                AudioPlayer.player.start(audioStream);
            //}
            //AudioPlayer.player.stop(audioStream);
        } catch (Exception e){
            System.out.println("Audio não work");
        }
    }

    public static void playGun(){
        try {
            InputStream in = new FileInputStream("Drum.wav");
            AudioStream as = new AudioStream(in);

            //while (true){
            AudioPlayer.player.start(as);
            //}
            //AudioPlayer.player.stop(audioStream);
        } catch (Exception e){
            System.out.println("Audio não work");
        }
    }

}
