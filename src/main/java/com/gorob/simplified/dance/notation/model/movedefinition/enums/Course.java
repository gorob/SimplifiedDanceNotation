package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum Course {
    NONE(""),

    LINEAR("COURSE_LINEAR"),
    ARC("COURSE_ARC");

    private String nameKey;

    Course(String nameKey){
        this.nameKey = nameKey;
    }
}
