package com.example.demo.features.article.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Repetition {
    FIRST_READING("first reading", 1),
    FIRST_RE_READING( "1", 3),
    SECOND_RE_READING( "2", 7),
    THIRD_RE_READING( "3", 16),
    FOURTH_RE_READING( "4", 60),
    COMPLETED( "completed", 0);

    private final String stepString;
    @Getter
    private final Integer nextPeriod;
    Repetition(String stepString, Integer nextPeriod) {
        this.stepString = stepString;
        this.nextPeriod = nextPeriod;
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
        return null;
    }


}
