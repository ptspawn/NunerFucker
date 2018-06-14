package org.academiadecodigo.bootcamp.Sound;


import java.applet.AudioClip;
import java.io.*;
import java.net.URL;

import javax.sound.sampled.*;

public class Sound implements AudioClip {


    Clip clip;

    public Sound(String filePath) {


        URL soundURL = Sound.class.getResource("/" + filePath);
        AudioInputStream inputStream;

        try {
            if (soundURL == null) {
                File file = new File(filePath);
                soundURL = file.toURI().toURL();
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);

            clip = AudioSystem.getClip();
            clip.open(inputStream);


        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void play() {
        clip.stop();
        clip.flush();
        clip.setFramePosition(0);
        clip.start();
    }

    @Override
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void stop() {
        clip.stop();
    }
}
