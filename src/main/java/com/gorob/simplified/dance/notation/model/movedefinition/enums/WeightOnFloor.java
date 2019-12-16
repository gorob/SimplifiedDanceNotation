package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum WeightOnFloor {
    NONE(""),

    RAISED("raised foot"),
    ON_HEEL("weight on heel"),
    ON_BALL("weight on ball"),
    ON_WHOLE("weight on whole foot"),

    TAP_HEEL("tap heel"),
    TAP_TOE("tap toe"),
    STOMP("stomp foot");

    private String defaultName;

    WeightOnFloor(String defaultName){
        this.defaultName = defaultName;
    }
}
