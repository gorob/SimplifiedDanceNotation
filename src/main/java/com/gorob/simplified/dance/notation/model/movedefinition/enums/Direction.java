package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum Direction {
    NONE(""),

    FORWARD("DIRECTION_FORWARD"),
    RIGHT_FORWARD("DIRECTION_RIGHT_FORWARD"),
    RIGHT("DIRECTION_RIGHT"),
    RIGHT_BACKWARD("DIRECTION_RIGHT_BACKWARD"),
    BACKWARD("DIRECTION_BACKWARD"),
    LEFT_BACKWARD("DIRECTION_LEFT_BACKWARD"),
    LEFT("DIRECTION_LEFT"),
    LEFT_FORWARD("DIRECTION_LEFT_FORWARD"),

    UP("DIRECTION_UP"),
    DOWN("DIRECTION_DOWN"),

    CLOSE("DIRECTION_CLOSE");

    private String nameKey;

    Direction(String nameKey){
        this.nameKey = nameKey;
    }
}
