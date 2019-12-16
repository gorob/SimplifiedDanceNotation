package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum BodyPart {
    LEFT_FOOT("LF", "left foot"),
    RIGHT_FOOT("RF", "right foot"),

    LEFT_HAND("LH", "left hand"),
    RIGHT_HAND("RH", "right hand");

    private String shortName;
    private String defaultName;

    BodyPart(String shortName, String defaultName){
        this.shortName = shortName;
        this.defaultName = defaultName;
    }
}
