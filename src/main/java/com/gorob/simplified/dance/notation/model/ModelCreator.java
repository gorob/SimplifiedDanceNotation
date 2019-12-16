package com.gorob.simplified.dance.notation.model;

import com.gorob.simplified.dance.notation.model.dance.MediaRef;
import com.gorob.simplified.dance.notation.model.dance.MediaService;
import com.gorob.simplified.dance.notation.model.dance.MediaType;
import com.gorob.simplified.dance.notation.model.movedefinition.*;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;

import java.util.Arrays;

public class ModelCreator {
    private ModelCreator(){
    }

    public static DanceMoveDefinition createDanceMoveDefinition(String id, String defaultName, DanceMoveVariantDefinition... danceMoveVariantDefinitions){
        DanceMoveDefinition danceMoveDefinition = createDanceMoveDefinition(id, defaultName);
        Arrays.stream(danceMoveVariantDefinitions).forEach(danceMoveVariantDefinition -> danceMoveDefinition.addDanceMoveVariantDefinition(danceMoveVariantDefinition));
        return danceMoveDefinition;
    }

    public static DanceMoveVariantDefinition createDanceMoveVariantDefinition(String id, String defaultName, BodyMovement... bodyMovements){
        DanceMoveVariantDefinition danceMoveVariantDefinition = createDanceMoveVariantDefinition(id, defaultName);
        Arrays.stream(bodyMovements).forEach(bodyMovement -> danceMoveVariantDefinition.addBodyMovement(bodyMovement));
        return danceMoveVariantDefinition;
    }

    public static BodyMovement createBodyMovement(int countNr, BodyPartMovement... bodyPartMovements){
        BodyMovement bodyMovement = createBodyMovement(countNr);
        Arrays.stream(bodyPartMovements).forEach(bodyPartMovement -> bodyMovement.addBodyPartMovement(bodyPartMovement));
        return bodyMovement;
    }

    public static BodyPartMovement createBodyPartMovement(BodyPart bodyPart, MovementAttributes movementAttributesXY, MovementAttributes movementAttributesZ, WeightOnFloor weightOnFloorEnd){
        return new BodyPartMovement(bodyPart, movementAttributesXY, movementAttributesZ, weightOnFloorEnd);
    }

    public static MovementAttributes createMovementAttributes(Direction direction, Course course, Distance distance, Rotation rotation){
        return new MovementAttributes(direction, course, distance, rotation);
    }

    public static MediaRef createMediaReference(MediaService mediaService, MediaType mediaType, String ref) {
        return new MediaRef(mediaService, mediaType, ref);
    }

    private static DanceMoveDefinition createDanceMoveDefinition(String id, String defaultName){
        return new DanceMoveDefinition(id, defaultName);
    }

    private static DanceMoveVariantDefinition createDanceMoveVariantDefinition(String id, String defaultName){
        return new DanceMoveVariantDefinition(id, defaultName);
    }

    private static BodyMovement createBodyMovement(int countNr){
        return new BodyMovement(countNr);
    }
}
