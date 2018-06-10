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
    AHCURTO2(new Sound("Sounds/voice/ahcurto2.wav")),
    AHFUCKERS(new Sound("Sounds/voice/ahfuckers.wav")),
    BASTARDS(new Sound("Sounds/voice/bastards.wav"));


    private final Sound voice;

    PlayerVoiceType(Sound voice) {
        this.voice = voice;
    }

    public void playSound() {
        switch (this) {
            case AAAAHHH:
                voice.play();
                break;
            case KILL:
                voice.play();
                break;
            case MUCHBETTER:
                voice.play();
                break;
            case DAMN:
                voice.play();
                break;
            case AHCURTO2:
                voice.play();
                break;
            case AHFUCKERS:
                voice.play();
                break;
            case BASTARDS:
                voice.play();
                break;
            case BIRTHCONTROL:
                voice.play();
                break;
            case EATSHIT:
                voice.play();
                break;
            case LIKETHERESR:
                voice.play();
                break;
            case MEDIEVAL:
                voice.play();
                break;
            case UGLY:
                voice.play();
                break;
            case YIPPIE:
                voice.play();
                break;
        }
    }

    public void stopSound() {
        voice.stop();
    }
}
