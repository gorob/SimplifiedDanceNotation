package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

@Getter
public enum BodyPart {
    LEFT_FOOT("BODY_PART_LEFT_FOOT_SHORT", "BODY_PART_LEFT_FOOT"),
    RIGHT_FOOT("BODY_PART_RIGHT_FOOT_SHORT", "BODY_PART_RIGHT_FOOT"),

    LEFT_HAND("BODY_PART_LEFT_HAND_SHORT", "BODY_PART_LEFT_HAND"),
    RIGHT_HAND("BODY_PART_RIGHT_HAND_SHORT", "BODY_PART_RIGHT_HAND");

    private String shortNameKey;
    private String nameKey;

    BodyPart(String shortNameKey, String nameKey){
        this.shortNameKey = shortNameKey;
        this.nameKey = nameKey;
    }
}
