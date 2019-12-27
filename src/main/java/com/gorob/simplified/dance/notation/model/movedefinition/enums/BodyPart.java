package com.gorob.simplified.dance.notation.model.movedefinition.enums;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public enum BodyPart {
    LEFT_FOOT(BodyPartGroup.FEET),
    RIGHT_FOOT(BodyPartGroup.FEET),
    LEFT_HAND(BodyPartGroup.HANDS),
    RIGHT_HAND(BodyPartGroup.HANDS);

    private BodyPartGroup bodyPartGroup;

    BodyPart(BodyPartGroup bodyPartGroup) {
        this.bodyPartGroup = bodyPartGroup;
    }

    public boolean isFoot(){
        return getBodyPartsFeet().contains(this);
    }

    public boolean isHand(){
        return getBodyPartsHands().contains(this);
    }

    public static List<BodyPart> getBodyPartsFeet(){
        return Arrays.stream(BodyPart.values()).filter(bodyPart -> bodyPart.getBodyPartGroup().equals(BodyPartGroup.FEET)).collect(Collectors.toList());
    }

    public static List<BodyPart> getBodyPartsHands(){
        return Arrays.stream(BodyPart.values()).filter(bodyPart -> bodyPart.getBodyPartGroup().equals(BodyPartGroup.HANDS)).collect(Collectors.toList());
    }
}
