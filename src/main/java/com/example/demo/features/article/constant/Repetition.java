package com.example.demo.features.article.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;


public enum Repetition {
    FIRST(1, "first reading"),
    REPEAT_ONE(3, "1"),
    REPEAT_TWO(7, "2"),
    REPEAT_THREE(16, "3"),
    REPEAT_FOUR(60, "4"),
    COMPLETED(null, "completed");

    @Getter @Setter
    private String stepString;
    @Getter @Setter
    private Integer nextPeriod;

    Repetition(Integer nextPeriod, String stepString) {
        this.nextPeriod = nextPeriod;
        this.stepString = stepString;
    }

    @JsonValue
    public String getStepString() {
        return stepString;
    }

    @JsonCreator
    public static Repetition fromStepString(String stepString) {
        for (Repetition contentType : Repetition.values()) {
            if (contentType.getStepString().equals(stepString)) {
                return contentType;
            }
        }
        return null;
    }

    public static Repetition fromInteger(Integer value) {
        for (Repetition repetition : Repetition.values()) {
            if (repetition.getNextPeriod() == value) {
                return repetition;
            }
        }

        return null;
    }
}
