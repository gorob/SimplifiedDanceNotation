package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.model.IBodyPartMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.BodyPart;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.WeightOnFloor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BodyPartMovement implements IBodyPartMovement {
    private BodyPart bodyPart;

    private MovementAttributes movementAttributesXY;
    private MovementAttributes movementAttributesZ;

    private WeightOnFloor weightOnFloorEnd;
}
