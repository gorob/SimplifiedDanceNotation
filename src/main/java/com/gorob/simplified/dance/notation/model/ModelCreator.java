package com.gorob.simplified.dance.notation.model;

import com.gorob.simplified.dance.notation.model.dance.*;
import com.gorob.simplified.dance.notation.model.movedefinition.*;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import com.gorob.simplified.dance.notation.pdf.DanceOverview;

import java.io.File;
import java.util.Arrays;

public class ModelCreator {
    private ModelCreator(){
    }

    public static DanceMoveDefinition createDanceMoveDefinition(String id, String defaultName, DanceMoveVariantDefinition... danceMoveVariantDefinitions){
        DanceMoveDefinition danceMoveDefinition = createDanceMoveDefinition(id, defaultName);
        Arrays.stream(danceMoveVariantDefinitions).forEach(danceMoveVariantDefinition -> danceMoveDefinition.addDanceMoveVariantDefinition(danceMoveVariantDefinition));
        return danceMoveDefinition;
    }

    public static DanceMoveVariantDefinition createDanceMoveVariantDefinition(String id, String defaultName, BodyMovementGroup... bodyMovementGroups){
        DanceMoveVariantDefinition danceMoveVariantDefinition = createDanceMoveVariantDefinition(id, defaultName);
        Arrays.stream(bodyMovementGroups).forEach(bodyMovementGroup -> danceMoveVariantDefinition.addBodyMovementGroup(bodyMovementGroup));
        return danceMoveVariantDefinition;
    }

    public static BodyMovementGroup createBodyMovementGroup(int counts, BodyMovement... bodyMovementGroups){
        BodyMovementGroup bodyMovementGroup = createBodyMovementGroup(counts);
        Arrays.stream(bodyMovementGroups).forEach(bodyMovement -> bodyMovementGroup.addBodyMovement(bodyMovement));
        return bodyMovementGroup;
    }

    public static BodyMovement createBodyMovement(BodyPartMovement... bodyPartMovements){
        BodyMovement bodyMovement = createBodyMovement();
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

    public static DanceMoveDefinitions createDanceMoveDefinitions(File dmdFilesFolder){
        return new DanceMoveDefinitions(dmdFilesFolder);
    }

    public static Dance createDance(String danceTitle, int wall, int count, int startCount, String timeSignature,
                                    String choreoTitle, String choreoCreator, int choreoYear,
                                    String musicTitle, String musicCreator, int musicYear){
        Dance dance = new Dance(danceTitle, wall, count, startCount, timeSignature);
        dance.addChoreographyMetaInfo(new ChoreographyMetaInfo(choreoTitle, choreoCreator, choreoYear));
        dance.addMusicMetaInfo(new MusicMetaInfo(musicTitle, musicCreator, musicYear));
        return dance;
    }

    public static DanceOverview createDanceOverview(Dance dance) {
        return new DanceOverview(dance);
    }

    private static DanceMoveDefinition createDanceMoveDefinition(String id, String defaultName){
        return new DanceMoveDefinition(id, defaultName);
    }

    private static DanceMoveVariantDefinition createDanceMoveVariantDefinition(String id, String defaultName){
        return new DanceMoveVariantDefinition(id, defaultName);
    }

    public static BodyMovementGroup createBodyMovementGroup(int counts) {
        return new BodyMovementGroup(counts);
    }

    private static BodyMovement createBodyMovement(){
        return new BodyMovement();
    }
}
