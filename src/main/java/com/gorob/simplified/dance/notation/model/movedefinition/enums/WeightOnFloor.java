package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum WeightOnFloor {
    NONE(""),

    RAISED("WEIGHT_ON_FLOOR_RAISED"),
    ON_HEEL("WEIGHT_ON_FLOOR_ON_HEEL"),
    ON_BALL("WEIGHT_ON_FLOOR_ON_BALL"),
    ON_WHOLE("WEIGHT_ON_FLOOR_ON_WHOLE"),

    TAP_HEEL("WEIGHT_ON_FLOOR_TAP_HEEL"),
    TAP_TOE("WEIGHT_ON_FLOOR_TAP_TOE"),
    STOMP("WEIGHT_ON_FLOOR_STOMP");

    private String nameKey;

    WeightOnFloor(String nameKey){
        this.nameKey = nameKey;
    }
}
