package org.academiadecodigo.bootcamp.enums;

/**
 * Created by codecadet on 09/06/2018.
 */
public enum BloodType {
    BLOOD1("Resources/Characters/BloodStains/blood15.png"),
    BLOOD2("Resources/Characters/BloodStains/blood1.png"),
    BLOOD3("Resources/Characters/BloodStains/blood2.png"),
    BLOOD4("Resources/Characters/BloodStains/blood3.png"),
    BLOOD5("Resources/Characters/BloodStains/blood4.png"),
    BLOOD6("Resources/Characters/BloodStains/blood5.png"),
    BLOOD7("Resources/Characters/BloodStains/blood6.png"),
    BLOOD8("Resources/Characters/BloodStains/blood7.png"),
    BLOOD9("Resources/Characters/BloodStains/blood8.png"),
    BLOOD10("Resources/Characters/BloodStains/blood9.png"),
    BLOOD11("Resources/Characters/BloodStains/blood10.png"),
    BLOOD12("Resources/Characters/BloodStains/blood11.png"),
    BLOOD13("Resources/Characters/BloodStains/blood12.png"),
    BLOOD14("Resources/Characters/BloodStains/blood13.png"),
    BLOOD15("Resources/Characters/BloodStains/blood14.png"),
    BLOOD16("Resources/Characters/BloodStains/blood16.png");

    private String path;

    BloodType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
