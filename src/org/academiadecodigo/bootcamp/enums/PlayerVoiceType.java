package org.academiadecodigo.bootcamp.enums;

import org.academiadecodigo.bootcamp.Sound.Sound;

/**
 * Created by codecadet on 10/06/2018.
 */
public enum PlayerVoiceType {

    AAAAHHH(new Sound("Resources/Sounds/voice/aaaahhh.wav")),
    KILL(new Sound("Resources/Sounds/voice/kill.wav")),
    MUCHBETTER(new Sound("Resources/Sounds/voice/muchbetter.wav")),
    DAMN(new Sound("Resources/Sounds/voice/damn.wav")),
    BIRTHCONTROL(new Sound("Resources/Sounds/voice/birthcontrol.wav")),
    EATSHIT(new Sound("Resources/Sounds/voice/eatshit.wav")),
    LIKETHERESR(new Sound("Resources/Sounds/voice/liketheresr.wav")),
    MEDIEVAL(new Sound("Resources/Sounds/voice/medieval.wav")),
    UGLY(new Sound("Resources/Sounds/voice/ugly.wav")),
    YIPPIE(new Sound("Resources/Sounds/voice/yippie.wav")),
    AHCURTO2(new Sound("Resources/Sounds/voice/ahcurto2.wav")),
    AHFUCKERS(new Sound("Resources/Sounds/voice/ahfuckers.wav")),
    BASTARDS(new Sound("Resources/Sounds/voice/bastards.wav"));


    private final Sound voice;

    PlayerVoiceType(Sound voice) {
        this.voice = voice;
    }

    public void playSound() {
        switch (this) {
            case AAAAHHH:
                voice.stop();
                voice.play();
                break;
            case KILL:
                voice.stop();
                voice.play();
                break;
            case MUCHBETTER:
                voice.stop();
                voice.play();
                break;
            case DAMN:
                voice.stop();
                voice.play();
                break;
            case AHCURTO2:
                voice.stop();
                voice.play();
                break;
            case AHFUCKERS:
                voice.play();
                break;
            case BASTARDS:
                voice.stop();
                voice.play();
                break;
            case BIRTHCONTROL:
                voice.stop();
                voice.play();
                break;
            case EATSHIT:
                voice.stop();
                voice.play();
                break;
            case LIKETHERESR:
                voice.stop();
                voice.play();
                break;
            case MEDIEVAL:
                voice.stop();
                voice.play();
                break;
            case UGLY:
                voice.stop();
                voice.play();
                break;
            case YIPPIE:
                voice.stop();
                voice.play();
                break;
        }
    }

    public void stopSound() {
        voice.stop();
    }
}
