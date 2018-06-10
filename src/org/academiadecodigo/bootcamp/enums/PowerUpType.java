package org.academiadecodigo.bootcamp.enums;

public enum PowerUpType {
    HEALTH(10, "Resources/PowerUps/life.png"),
    TIME(5000, "Resources/PowerUps/pocketwatch.png"),
    GUN(5000, "Resources/PowerUps/gunpowerup.png"),
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
