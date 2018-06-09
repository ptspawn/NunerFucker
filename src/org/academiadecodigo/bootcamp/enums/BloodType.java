package org.academiadecodigo.bootcamp.enums;

/**
 * Created by codecadet on 09/06/2018.
 */
public enum BloodType {
    BLOOD1("Characters/BloodStains/blood.jpg"),
    BLOOD2("Characters/BloodStains/blood1.jpg"),
    BLOOD3("Characters/BloodStains/blood2.jpg"),
    BLOOD4("Characters/BloodStains/blood3.jpg"),
    BLOOD5("Characters/BloodStains/blood.jpg"),
    BLOOD6("Characters/BloodStains/blood.jpg"),
    BLOOD7("Characters/BloodStains/blood.jpg"),
    BLOOD8("Characters/BloodStains/blood.jpg"),
    BLOOD9("Characters/BloodStains/blood.jpg"),
    BLOOD10("Characters/BloodStains/blood.jpg"),
    BLOOD11("Characters/BloodStains/blood.jpg"),
    BLOOD12("Characters/BloodStains/blood.jpg"),
    BLOOD13("Characters/BloodStains/blood.jpg"),
    BLOOD14("Characters/BloodStains/blood.jpg"),
    BLOOD15("Characters/BloodStains/blood.jpg");

    private String path;

    BloodType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
