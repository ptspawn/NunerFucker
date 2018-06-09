package org.academiadecodigo.bootcamp.Sound;

import sun.audio.*;
import  java.io.*;

public class Sound {

    private static ContinuousAudioDataStream pLoop;
    private static AudioStream pOnce;

    public static void playLoop(String fileName){

        try {
            InputStream in = new FileInputStream(fileName);
            AudioStream as = new AudioStream(in);

            AudioData data = as.getData();
            pLoop = new ContinuousAudioDataStream(data);

            AudioPlayer.player.start(pLoop);

        } catch (Exception e){
            System.out.println("Audio doesn't work " + e.getMessage());
        }
    }

    public static void playOnce(String fileName){
        try {
            InputStream in = new FileInputStream(fileName);
            AudioStream pOnce = new AudioStream(in);

            AudioPlayer.player.start(pOnce);

        } catch (Exception e){
            System.out.println("Audio doesn't work");
        }
    }

    public static void stopLoop(){

        AudioPlayer.player.stop(pLoop);


    }

}
