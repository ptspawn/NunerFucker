package org.academiadecodigo.bootcamp.Sound;


import java.applet.AudioClip;
import java.io.*;
import sun.audio.*;

public class Sound implements AudioClip {

    private String filePath;
    private AudioData audioData;
    private AudioDataStream audioStream;
    private ContinuousAudioDataStream continuousAudioDataStream;

    public Sound(String filePath){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            AudioStream audioStream = new AudioStream(fis);
            audioData = audioStream.getData();
            this.audioStream = null;
            continuousAudioDataStream = null;
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void play() {
        audioStream = new AudioDataStream(audioData);
        AudioPlayer.player.start(audioStream);
    }

    @Override
    public void loop() {
        continuousAudioDataStream = new ContinuousAudioDataStream(audioData);
        AudioPlayer.player.start(continuousAudioDataStream);
    }

    @Override
    public void stop() {
        if (audioStream != null)
            AudioPlayer.player.stop(audioStream);
        if (continuousAudioDataStream != null)
            AudioPlayer.player.stop(continuousAudioDataStream);
    }
}
