package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum Rotation {
    NONE(""),

    EIGHTH_TURN( "ROTATION_45"),
    QUARTER_TURN( "ROTATION_90"),
    HALF_TURN( "ROTATION_180"),
    THREE_QUARTER_TURN( "ROTATION_270"),
    FULL_TURN("ROTATION_360");

    private String nameKey;

    Rotation(String nameKey){
        this.nameKey = nameKey;
    }
}
