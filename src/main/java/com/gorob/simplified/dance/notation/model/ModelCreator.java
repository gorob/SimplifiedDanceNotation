package com.gorob.simplified.dance.notation.model;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.dance.*;
import com.gorob.simplified.dance.notation.model.movedefinition.*;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import com.gorob.simplified.dance.notation.pdf.*;

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

    public static Dance createDance(String danceTitle, int wall, int count, int startCount, TimeSignature timeSignature,
                                    String choreoTitle, String choreoCreator, int choreoYear,
                                    String musicTitle, String musicCreator, int musicYear){
        Dance dance = new Dance(danceTitle, wall, count, startCount, timeSignature);
        dance.addChoreographyMetaInfo(new ChoreographyMetaInfo(choreoTitle, choreoCreator, choreoYear));
        dance.addMusicMetaInfo(new MusicMetaInfo(musicTitle, musicCreator, musicYear));
        return dance;
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

    public static DanceOverview createDanceOverview(Dance dance, Messages messages) {
        return new DanceOverview(dance, messages);
    }

    public static DanceMoveInstructionText createDanceMoveInstructionText(DanceMoveVariantDefinition danceMoveVariantDefinition, TimeSignature timeSignature, Messages messages) {
        return new DanceMoveInstructionText(danceMoveVariantDefinition, timeSignature, messages);
    }

    public static BodyMovementGroupInstructionText createBodyMovementGroupInstructionText(BodyMovementGroup bodyMovementGroup, TimeSignature timeSignature, Messages messages) {
        return new BodyMovementGroupInstructionText(bodyMovementGroup, timeSignature, messages);
    }

    public static BodyMovementInstructionText createBodyMovementInstructionText(BodyMovement bodyMovement, String countSyllable, Messages messages) {
        return new BodyMovementInstructionText(bodyMovement, countSyllable, messages);
    }

    public static BodyPartMovementInstructionText createBodyPartMovementInstructionText(BodyPartMovement bodyPartMovement, Messages messages) {
        return new BodyPartMovementInstructionText(bodyPartMovement, messages);
    }

    public static TimeSignature createTimeSignature(String signature) {
        return new TimeSignature(signature);
    }

}
