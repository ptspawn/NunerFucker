package org.academiadecodigo.bootcamp.enums;

import org.academiadecodigo.bootcamp.Sound.Sound;

public enum SoundType {
    BACKGROUND(new Sound("resources/Sounds/background.wav")),
    BACKGROUND2(new Sound("resources/Sounds/background2.wav")),
    BACKGROUND3(new Sound("resources/Sounds/background3.wav")),
    BACKGROUND4(new Sound("resources/Sounds/background4.wav")),
    BOSS(new Sound("resources/Sounds/boss.wav")),
    GAMEOVER(new Sound("resources/Sounds/gameOver.wav")),
    MENU(new Sound("resources/Sounds/menu.wav")),
    ROCKET(new Sound("resources/Sounds/rocket.wav")),
    GUN(new Sound("resources/Sounds/bullets/skorpion.wav")),
    PUNCH(new Sound("resources/Sounds/punch.wav")),
    ELEVATOR(new Sound("resources/Sounds/ElevatorMusic.wav")),
    BULLETTIME(new Sound("resources/Sounds/bullets/BulletTIme.wav"));

    private final Sound sound;

    SoundType(Sound sound){
        this.sound = sound;
    }

    public void playSound(){
        switch (this){
            case BACKGROUND:
                sound.loop();
                break;
            case BACKGROUND2:
                sound.loop();
                break;
            case BACKGROUND3:
                sound.loop();
                break;
            case BACKGROUND4:
                sound.loop();
                break;
            case BOSS:
                sound.loop();
                break;
            case GAMEOVER:
                sound.play();
                break;
            case MENU:
                sound.loop();
                break;
            case ROCKET:
                sound.play();
                break;
            case GUN:

                sound.play();
                System.out.println("playing gun");
                break;
            case PUNCH:
                sound.play();
                break;
            case ELEVATOR:
                sound.loop();
                break;
            case BULLETTIME:
                sound.play();
                System.out.println("playeing buttlettime");
                break;

        }
    }

    public void stopSound(){
        sound.stop();
    }
}
