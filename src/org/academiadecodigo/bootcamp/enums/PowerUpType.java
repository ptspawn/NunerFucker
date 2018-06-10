package org.academiadecodigo.bootcamp.enums;

public enum PowerUpType {
    HEALTH(10, "PowerUps/Power-ups/PNG/life_power_up_1.png"),
    TIME(5000, "PowerUps/time.png"),
    GUN(5000, "PowerUps/gunPowerup.png"),
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
