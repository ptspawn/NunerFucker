package org.academiadecodigo.bootcamp.Sound;

import sun.audio.*;
import  java.io.*;

public class Sound {

    public static void playLoop(String fileName){

        try {
            InputStream in = new FileInputStream(fileName);
            AudioStream as = new AudioStream(in);

            AudioData data = as.getData();
            ContinuousAudioDataStream audioStream = new ContinuousAudioDataStream(data);

            AudioPlayer.player.start(audioStream);

        } catch (Exception e){
            System.out.println("Audio doesn't work");
        }
    }

    public static void playOnce(String fileName){
        try {
            InputStream in = new FileInputStream(fileName);
            AudioStream as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e){
            System.out.println("Audio doesn't work");
        }
    }

}
