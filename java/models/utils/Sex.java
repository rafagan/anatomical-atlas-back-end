package models.utils;

/**
 * Created by rafaganabreu on 01/10/14.
 */
public enum Sex {
    MALE("male"), FEMALE("female");

    String sex;
    Sex(String sex) {
        this.sex = sex;
    }

    public String toString() {
        return sex;
    }
}
