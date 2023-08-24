package com.sl.student.primary.model;

public enum Datatype {
    STRING(String.class),
    INTEGER(Integer.class),
    DOUBLE(Double.class);

    private Class<?> clazz;

    Datatype(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}

