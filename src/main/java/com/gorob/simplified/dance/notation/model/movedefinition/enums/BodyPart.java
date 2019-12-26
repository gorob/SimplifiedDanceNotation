package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum BodyPart {
    LEFT_FOOT,
    RIGHT_FOOT,
    LEFT_HAND,
    RIGHT_HAND;

    public boolean isFoot(){
        return this.equals(LEFT_FOOT) || this.equals(RIGHT_FOOT);
    }

    public boolean isHand(){
        return this.equals(LEFT_HAND) || this.equals(RIGHT_HAND);
    }
}
