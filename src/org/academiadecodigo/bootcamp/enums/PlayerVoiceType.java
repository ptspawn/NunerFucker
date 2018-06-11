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
    AHFUCKERS(new Sound("Resources/Sounds/voice/ahfuckers.wav")),
    BASTARDS(new Sound("Resources/Sounds/voice/bastards.wav")),
    AHCURTO2(new Sound("Resources/Sounds/voice/ahcurto.wav")),
    BIRTHCONTROL(new Sound("Resources/Sounds/voice/birthcontrol.wav")),
    EATSHIT(new Sound("Resources/Sounds/voice/eatshit.wav")),
    LIKETHERESR(new Sound("Resources/Sounds/voice/liketheresr.wav")),
    MEDIEVAL(new Sound("Resources/Sounds/voice/medieval.wav")),
    UGLY(new Sound("Resources/Sounds/voice/ugly.wav")),
    YIPPIE(new Sound("Resources/Sounds/voice/yippie.wav"));


    private final Sound voice;

    PlayerVoiceType(Sound voice) {
        this.voice = voice;
    }

    public void playSound() {
        System.out.println("sound");
        switch (this) {
            case AAAAHHH:
                System.out.println("0");
                voice.stop();
                voice.play();
                break;
            case KILL:
                System.out.println("1");
                voice.stop();
                voice.play();
                break;
            case MUCHBETTER:
                System.out.println("2");
                voice.stop();
                voice.play();
                break;
            case DAMN:
                voice.stop();
                System.out.println("3");
                voice.play();
                break;
            case AHCURTO2:
                System.out.println("4");
                voice.stop();
                voice.play();
                break;
            case AHFUCKERS:
                System.out.println("5");
                voice.stop();
                voice.play();
                break;
            case BASTARDS:
                System.out.println("6");
                voice.stop();
                voice.play();
                break;
            case BIRTHCONTROL:
                System.out.println("7");
                voice.stop();
                voice.play();
                break;
            case EATSHIT:
                System.out.println("8");
                voice.stop();
                voice.play();
                break;
            case LIKETHERESR:
                System.out.println("9");
                voice.stop();
                voice.play();
                break;
            case MEDIEVAL:
                System.out.println("10");
                voice.stop();
                voice.play();
                break;
            case UGLY:
                System.out.println("11");
                voice.stop();
                voice.play();
                break;
            case YIPPIE:
                System.out.println("12");
                voice.stop();
                voice.play();
                break;
        }
    }

    public void stopSound() {
        voice.stop();
    }
}
