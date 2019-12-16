package com.gorob.simplified.dance.notation;

import com.gorob.simplified.dance.notation.model.ModelCreator;
import com.gorob.simplified.dance.notation.model.movedefinition.*;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;

public class TestModelCreator {
    public DanceMoveDefinition createDefaultDanceMoveDefinition(DanceMoveVariantDefinition... danceMoveVariantDefinitions){
        return ModelCreator.createDanceMoveDefinition("DanceMoveDefinitionId", "DanceMoveDefinitionName", danceMoveVariantDefinitions);
    }

    public DanceMoveVariantDefinition createDefaultDanceMoveVariantDefinition(BodyMovement... bodyMovements){
        return ModelCreator.createDanceMoveVariantDefinition("DanceMoveDefinitionVariantId", "DanceMoveDefinitionVariantName", bodyMovements);
    }

    public BodyMovement createBodyMovement(int countNr, BodyPartMovement... bodyPartMovements) {
        return ModelCreator.createBodyMovement(countNr, bodyPartMovements);
    }

    public MovementAttributes createDefaultMovementAttributesXY(){
        return ModelCreator.createMovementAttributes(Direction.FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesXY_2(){
        return ModelCreator.createMovementAttributes(Direction.LEFT, Course.NONE, Distance.SMALL, Rotation.QUARTER_TURN);
    }

    public MovementAttributes createDefaultMovementAttributesXY_3(){
        return ModelCreator.createMovementAttributes(Direction.BACKWARD, Course.ARC, Distance.LARGE, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesXY_none(){
        return ModelCreator.createMovementAttributes(Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesZ(){
        return ModelCreator.createMovementAttributes(Direction.UP, Course.LINEAR, Distance.MEDIUM, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesZ_2(){
        return ModelCreator.createMovementAttributes(Direction.DOWN, Course.LINEAR, Distance.SMALL, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesZ_3(){
        return ModelCreator.createMovementAttributes(Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesZ_none(){
        return ModelCreator.createMovementAttributes(Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE);
    }

    public BodyPartMovement createDefaultBodyPartMovementXY(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_none();
        return ModelCreator.createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED);
    }

    public BodyPartMovement createDefaultBodyPartMovementXY_2(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_2();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_none();
        return ModelCreator.createBodyPartMovement(BodyPart.LEFT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.ON_BALL);
    }

    public BodyPartMovement createDefaultBodyPartMovementXY_3(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_3();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_none();
        return ModelCreator.createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.ON_WHOLE);
    }

    public BodyPartMovement createDefaultBodyPartMovementZ(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_none();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ();
        return ModelCreator.createBodyPartMovement(BodyPart.RIGHT_HAND, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED);
    }

    public BodyPartMovement createDefaultBodyPartMovementZ_2(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_none();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_2();
        return ModelCreator.createBodyPartMovement(BodyPart.LEFT_HAND, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED);
    }

    public BodyPartMovement createDefaultBodyPartMovementZ_3(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_none();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_3();
        return ModelCreator.createBodyPartMovement(BodyPart.RIGHT_HAND, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED);
    }
}