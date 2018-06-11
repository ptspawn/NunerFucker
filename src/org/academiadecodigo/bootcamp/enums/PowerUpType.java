package org.academiadecodigo.bootcamp.enums;

public enum PowerUpType {
    HEALTH(50, "resources/PowerUps/life.png"),
    TIME(250, "resources/PowerUps/pocketwatch.png"),
    GUN(250, "resources/PowerUps/gunpowerup.png"),
    WEED(100, "resources/PowerUps/weed.png");


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
