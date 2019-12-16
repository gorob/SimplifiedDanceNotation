package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum Course {
    NONE(""),

    LINEAR("straight"),
    ARC("within an arc");

    private String defaultName;

    Course(String defaultName){
        this.defaultName = defaultName;
    }
}
