package com.example.demo.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Status {
    COMPLETED("completed"), IN_PROGRESS("in_progress");

    private final String statusString;
    Status(String statusString) {
        this.statusString = statusString;
    }

    @JsonValue
    public String getStatusString(){
        return statusString;
    }

    @JsonCreator
    public static Status statusFromString(String text) {
        if(text == null) return COMPLETED;
        for (Status status : Status.values()) {
            if (status.statusString.equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + text);
    }
}
