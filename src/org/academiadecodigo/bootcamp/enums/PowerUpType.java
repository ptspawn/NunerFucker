package org.academiadecodigo.bootcamp.enums;

public enum PowerUpType {
    HEALTH(10, "PowerUps/life.png"),
    TIME(5000, "PowerUps/pocketwatch.png"),
    GUN(5000, "PowerUps/gunpowerup.png"),
    WEED(100, "PowerUps/weed.png");


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
