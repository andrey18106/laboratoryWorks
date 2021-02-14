package com.andrey18106.lab2;

public class SomeModel {
    public static int someStaticField = 0;
    private final int someField;
    public int somePublicField;

    public SomeModel(int field) {
        someField = field;
        someStaticField = field + 1;
        someStaticField++;
    }

    public int getSomeField() {
        return this.someField;
    }

}
