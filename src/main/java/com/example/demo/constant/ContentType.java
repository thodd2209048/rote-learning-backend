package com.example.demo.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ContentType {
    ARTICLE("article"), VIDEO("video"), NOTE("note");

    private final String contentTypeString;
    ContentType(String contentTypeString) {
        this.contentTypeString = contentTypeString;
    }

    @JsonValue
    public String getContentTypeString(){
        return contentTypeString;
    }

    @JsonCreator
    public static ContentType contentTypeFromString(String text){
        for(ContentType contentType: ContentType.values()){
            if(contentType.getContentTypeString().equals(text)){
                return contentType;
            }
        }
        throw new IllegalArgumentException("Invalid content type: " + text);
    }
}
