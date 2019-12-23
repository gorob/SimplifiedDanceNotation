package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum Distance {
    NONE(""),

    MINI("DISTANCE_MINI"),
    SMALL("DISTANCE_SMALL"),
    MEDIUM("DISTANCE_NORMAL"),
    LARGE("DISTANCE_LARGE");

    private String nameKey;

    Distance(String nameKey){
        this.nameKey = nameKey;
    }
}
