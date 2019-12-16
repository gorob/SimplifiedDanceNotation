package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum Direction {
    NONE(""),

    FORWARD("forward"),
    RIGHT_FORWARD("right-forward"),
    RIGHT("right"),
    RIGHT_BACKWARD("right-backward"),
    BACKWARD("backward"),
    LEFT_BACKWARD("left-backward"),
    LEFT("left"),
    LEFT_FORWARD("left-forward"),

    UP("up"),
    DOWN("down"),

    CLOSE("close");

    private String defaultName;

    Direction(String defaultName){
        this.defaultName = defaultName;
    }
}
