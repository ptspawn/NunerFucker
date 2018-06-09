package org.academiadecodigo.bootcamp.Sound;

public enum SoundType {
    BACKGROUND,
    BACKGROUND2,
    BACKGROUND3,
    BACKGROUND4,
    BOSS,
    ELEVATOR,
    GAMEOVER,
    MENU,
    ROCKET,
    GUN,
    PUNCH;

    public void playSound(){
        switch (this){
            case BACKGROUND:
                Sound.playLoop("Resources/Sounds/background.wav");
                break;
            case BACKGROUND2:
                Sound.playLoop("Resources/Sounds/background2.wav");
                break;
            case BACKGROUND3:
                Sound.playLoop("Resources/Sounds/background3.wav");
                break;
            case BACKGROUND4:
                Sound.playLoop("Resources/Sounds/background4.wav");
                break;
            case BOSS:
                Sound.playLoop("Resources/Sounds/boss.wav");
                break;
            case ELEVATOR:
                Sound.playLoop("Resources/Sounds/elevator.wav");
                break;
            case GAMEOVER:
                Sound.playLoop("Resources/Sounds/gameOver.wav");
                break;
            case MENU:
                Sound.playLoop("Resources/Sounds/menu.wav");
                break;
            case ROCKET:
                Sound.playLoop("Resources/Sounds/rocket.wav");
            case GUN:
                Sound.playOnce("Resources/Sounds/gun.wav");
                break;
            case PUNCH:
                Sound.playOnce("Resources/Sounds/punch.wav");
                break;
        }
    }
}
