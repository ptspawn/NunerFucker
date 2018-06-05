package org.academiadecodigo.bootcamp.Sound;

public enum SoundType {
    BACKGROUND,
    GUN,
    PUNCH;

    public void playSound(){
        switch (this){
            case BACKGROUND:
                Sound.playLoop("Resources/Sounds/background.wav");
                break;
            case GUN:
                Sound.playOnce("Resources/Sounds/gun.wav");
                break;
            case PUNCH:
                Sound.playOnce("Resources/Sounds/punch.wav");
                break;
        }
    }
}
