package org.academiadecodigo.bootcamp.enums;

/**
 * Created by codecadet on 09/06/2018.
 */
public enum BloodType {
    BLOOD1("Characters/BloodStains/blood15.jpg"),
    BLOOD2("Characters/BloodStains/blood1.jpg"),
    BLOOD3("Characters/BloodStains/blood2.jpg"),
    BLOOD4("Characters/BloodStains/blood3.jpg"),
    BLOOD5("Characters/BloodStains/blood4.jpg"),
    BLOOD6("Characters/BloodStains/blood5.jpg"),
    BLOOD7("Characters/BloodStains/blood6.jpg"),
    BLOOD8("Characters/BloodStains/blood7.jpg"),
    BLOOD9("Characters/BloodStains/blood8.jpg"),
    BLOOD10("Characters/BloodStains/blood9.jpg"),
    BLOOD11("Characters/BloodStains/blood10.jpg"),
    BLOOD12("Characters/BloodStains/blood11.jpg"),
    BLOOD13("Characters/BloodStains/blood12.jpg"),
    BLOOD14("Characters/BloodStains/blood13.jpg"),
    BLOOD15("Characters/BloodStains/blood14.jpg");

    private String path;

    BloodType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
