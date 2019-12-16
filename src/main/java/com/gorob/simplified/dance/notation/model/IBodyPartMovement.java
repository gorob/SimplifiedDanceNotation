package com.gorob.simplified.dance.notation.model;

import com.gorob.simplified.dance.notation.model.movedefinition.MovementAttributes;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.BodyPart;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.WeightOnFloor;

public interface IBodyPartMovement {
    BodyPart getBodyPart();

    MovementAttributes getMovementAttributesXY();
    MovementAttributes getMovementAttributesZ();

    WeightOnFloor getWeightOnFloorEnd();
}
