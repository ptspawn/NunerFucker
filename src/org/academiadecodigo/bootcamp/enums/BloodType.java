package org.academiadecodigo.bootcamp.enums;

/**
 * Created by codecadet on 09/06/2018.
 */
public enum BloodType {
    BLOOD1("Characters/BloodStains/blood15.png"),
    BLOOD2("Characters/BloodStains/blood1.png"),
    BLOOD3("Characters/BloodStains/blood2.png"),
    BLOOD4("Characters/BloodStains/blood3.png"),
    BLOOD5("Characters/BloodStains/blood4.png"),
    BLOOD6("Characters/BloodStains/blood5.png"),
    BLOOD7("Characters/BloodStains/blood6.png"),
    BLOOD8("Characters/BloodStains/blood7.png"),
    BLOOD9("Characters/BloodStains/blood8.png"),
    BLOOD10("Characters/BloodStains/blood9.png"),
    BLOOD11("Characters/BloodStains/blood10.png"),
    BLOOD12("Characters/BloodStains/blood11.png"),
    BLOOD13("Characters/BloodStains/blood12.png"),
    BLOOD14("Characters/BloodStains/blood13.png"),
    BLOOD15("Characters/BloodStains/blood14.png"),
    BLOOD16("Characters/BloodStains/blood16.png");

    private String path;

    BloodType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
