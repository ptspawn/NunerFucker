package org.academiadecodigo.bootcamp.enums;

public enum PowerUpType {
    HEALTH(50, "Resources/PowerUps/life.png"),
    TIME(250, "Resources/PowerUps/pocketwatch.png"),
    GUN(250, "Resources/PowerUps/gunpowerup.png"),
    WEED(100, "Resources/PowerUps/weed.png");


    private int value;
    private String path;

    PowerUpType(int value, String path) {
        this.value = value;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public int getValue() {
        return value;

    }
}
