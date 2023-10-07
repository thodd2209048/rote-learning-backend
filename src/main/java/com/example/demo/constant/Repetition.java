package com.example.demo.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Repetition {
    FIRST_READING(0, "first reading"),
    FIRST_RE_READING(1, "1"),
    SECOND_RE_READING(2, "2"),
    THIRD_RE_READING(3, "3"),
    FOURTH_RE_READING(4, "4"),
    COMPLETED(5, "completed");

    @Getter
    private final Integer step;
    private final String stepString;
    Repetition(Integer step, String stepString) {
        this.step = step;
        this.stepString = stepString;
    }



    @JsonCreator
    public static Repetition contentTypeFromInteger(Integer step){
        for(Repetition contentType: Repetition.values()){
            if(contentType.getStep().equals(step)){
                return contentType;
            }
        }
        throw new IllegalArgumentException("Invalid content type: " + step);
    }

    @JsonValue
    public String getStepString(){
        return stepString;
    }

    @JsonCreator
    public static Repetition contentTypeFromString(String stepString){
        for(Repetition contentType: Repetition.values()){
            if(contentType.getStepString().equals(stepString)){
                return contentType;
            }
        }
        throw new IllegalArgumentException("Invalid content type: " + stepString);
    }


}
