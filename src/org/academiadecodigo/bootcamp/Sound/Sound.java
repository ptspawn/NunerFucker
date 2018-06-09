package org.academiadecodigo.bootcamp.Sound;


import java.applet.AudioClip;
import java.io.*;
import sun.audio.*;

public class Sound implements AudioClip {

    private String filePath;
    private AudioData audiodata;
    private AudioDataStream audiostream;
    private ContinuousAudioDataStream continuousaudiostream;

    public Sound(String filePath){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            AudioStream audioStream = new AudioStream(fis);
            audiodata = audioStream.getData();
            audiostream = null;
            continuousaudiostream = null;
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void play() {
        audiostream = new AudioDataStream(audiodata);
        AudioPlayer.player.start(audiostream);
    }

    @Override
    public void loop() {
        continuousaudiostream = new ContinuousAudioDataStream(audiodata);
        AudioPlayer.player.start(continuousaudiostream);
    }

    @Override
    public void stop() {
        if (audiostream != null)
            AudioPlayer.player.stop(audiostream);
        if (continuousaudiostream != null)
            AudioPlayer.player.stop(continuousaudiostream);
    }
}
