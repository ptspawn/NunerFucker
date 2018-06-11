package org.academiadecodigo.bootcamp.enums;

/**
 * Created by codecadet on 09/06/2018.
 */
public enum BloodType {
    BLOOD1("resources/Characters/BloodStains/blood15.png"),
    BLOOD2("resources/Characters/BloodStains/blood1.png"),
    BLOOD3("resources/Characters/BloodStains/blood2.png"),
    BLOOD4("resources/Characters/BloodStains/blood3.png"),
    BLOOD5("resources/Characters/BloodStains/blood4.png"),
    BLOOD6("resources/Characters/BloodStains/blood5.png"),
    BLOOD7("resources/Characters/BloodStains/blood6.png"),
    BLOOD8("resources/Characters/BloodStains/blood7.png"),
    BLOOD9("resources/Characters/BloodStains/blood8.png"),
    BLOOD10("resources/Characters/BloodStains/blood9.png"),
    BLOOD11("resources/Characters/BloodStains/blood10.png"),
    BLOOD12("resources/Characters/BloodStains/blood11.png"),
    BLOOD13("resources/Characters/BloodStains/blood12.png"),
    BLOOD14("resources/Characters/BloodStains/blood13.png"),
    BLOOD15("resources/Characters/BloodStains/blood14.png"),
    BLOOD16("resources/Characters/BloodStains/blood16.png");

    private String path;

    BloodType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
