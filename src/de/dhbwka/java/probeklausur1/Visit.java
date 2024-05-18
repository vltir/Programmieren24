package de.dhbwka.java.probeklausur1;

import java.util.Arrays;
import java.util.Objects;

public class Visit {
    private final Field[] fields;

    public Visit(Field[] fields) {
        if(fields.length>3)throw new IllegalArgumentException("Zu viele Würfe");
        this.fields = fields;
    }

    public Field[] getFields() {
        return fields;
    }

    public int getValue(){
        return Arrays.stream(fields).filter(Objects::nonNull).mapToInt(Field::getValue).sum();
    }

    public Field getLastField(){
        return fields[fields.length-1];
    }
}

