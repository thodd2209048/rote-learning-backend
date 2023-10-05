package com.example.demo.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Repetition {
    NOT_READ(0),
    FIRST_READ(1),
    SECOND_READ(2),
    THIRD_READ(3),
    FOURTH_READ(4),
    COMPLETED(5);

    private final Integer step;
    Repetition(Integer step) {
        this.step = step;
    }

    @JsonValue
    public Integer getStep(){
        return step;
    }

    @JsonCreator
    public static Repetition contentTypeFromString(Integer step){
        for(Repetition contentType: Repetition.values()){
            if(contentType.getStep().equals(step)){
                return contentType;
            }
        }
        throw new IllegalArgumentException("Invalid content type: " + step);
    }
}
