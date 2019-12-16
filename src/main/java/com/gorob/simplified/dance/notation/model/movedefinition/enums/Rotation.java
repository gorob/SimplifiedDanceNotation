package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum Rotation {
    NONE(0),

    EIGHTH_TURN( 45),
    QUARTER_TURN( 90),
    HALF_TURN( 180),
    THREE_QUARTER_TURN( 270),
    FULL_TURN(360);

    private int degree;

    Rotation(int degree){
        this.degree = degree;
    }
}
