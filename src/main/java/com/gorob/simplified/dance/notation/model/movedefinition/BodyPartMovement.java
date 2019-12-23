package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.model.movedefinition.enums.BodyPart;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.WeightOnFloor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BodyPartMovement {
    private BodyPart bodyPart;

    private MovementAttributes movementAttributesXY;
    private MovementAttributes movementAttributesZ;

    private WeightOnFloor weightOnFloorEnd;
}
