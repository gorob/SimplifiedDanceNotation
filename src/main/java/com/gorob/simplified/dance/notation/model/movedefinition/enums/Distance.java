package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum Distance {
    NONE(""),

    MINI("mini"),
    SMALL("small"),
    MEDIUM("normal"),
    LARGE("large");

    private String defaultName;

    Distance(String defaultName){
        this.defaultName = defaultName;
    }
}
