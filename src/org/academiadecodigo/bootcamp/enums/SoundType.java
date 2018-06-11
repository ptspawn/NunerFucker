package org.academiadecodigo.bootcamp.enums;

import org.academiadecodigo.bootcamp.Sound.Sound;

public enum SoundType {
    BACKGROUND(new Sound("Resources/Sounds/background.wav")),
    BACKGROUND2(new Sound("Resources/Sounds/background2.wav")),
    BACKGROUND3(new Sound("Resources/Sounds/background3.wav")),
    BACKGROUND4(new Sound("Resources/Sounds/background4.wav")),
    BOSS(new Sound("Resources/Sounds/boss.wav")),
    GAMEOVER(new Sound("Resources/Sounds/gameOver.wav")),
    MENU(new Sound("Resources/Sounds/menu.wav")),
    ROCKET(new Sound("Resources/Sounds/rocket.wav")),
    GUN(new Sound("Resources/Sounds/bullets/skorpion.wav")),
    PUNCH(new Sound("Resources/Sounds/punch.wav")),
    ELEVATOR(new Sound("Resources/Sounds/ElevatorMusic.wav")),
    BULLETTIME(new Sound("Resources/Sounds/bullets/BulletTIme.wav"));

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
                break;
            case PUNCH:
                sound.play();
                break;
            case ELEVATOR:
                sound.loop();
                break;
            case BULLETTIME:
                sound.play();
                break;

        }
    }

    public void stopSound(){
        sound.stop();
    }
}
