package com.gorob.simplified.dance.notation;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.ModelCreator;
import com.gorob.simplified.dance.notation.model.dance.*;
import com.gorob.simplified.dance.notation.model.movedefinition.*;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import com.gorob.simplified.dance.notation.pdf.BodyMovementGroupInstructionText;
import com.gorob.simplified.dance.notation.pdf.BodyMovementInstructionText;
import com.gorob.simplified.dance.notation.pdf.BodyPartMovementInstructionText;
import com.gorob.simplified.dance.notation.pdf.DanceOverview;

import java.io.File;
import java.io.IOException;

public class TestModelCreator {
    public DanceMoveDefinition createDefaultDanceMoveDefinition(DanceMoveVariantDefinition... danceMoveVariantDefinitions){
        return ModelCreator.createDanceMoveDefinition("DanceMoveDefinitionId", "DanceMoveDefinitionName", danceMoveVariantDefinitions);
    }

    public DanceMoveVariantDefinition createDefaultDanceMoveVariantDefinition(BodyMovementGroup... bodyMovementGroups){
        return ModelCreator.createDanceMoveVariantDefinition("DanceMoveDefinitionVariantId", "DanceMoveDefinitionVariantName", bodyMovementGroups);
    }

    public BodyMovementGroup createBodyMovementGroup(int counts, BodyMovement... bodyMovements) {
        return ModelCreator.createBodyMovementGroup(counts, bodyMovements);
    }

    public BodyMovement createBodyMovement(BodyPartMovement... bodyPartMovements) {
        return ModelCreator.createBodyMovement(bodyPartMovements);
    }

    public MovementAttributes createDefaultMovementAttributesXY(){
        return createMovementAttributes(Direction.FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesXY_2(){
        return createMovementAttributes(Direction.LEFT, Course.NONE, Distance.NONE, Rotation.QUARTER_TURN);
    }

    public MovementAttributes createDefaultMovementAttributesXY_3(){
        return createMovementAttributes(Direction.BACKWARD, Course.ARC, Distance.LARGE, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesXY_none(){
        return createMovementAttributes(Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesZ(){
        return createMovementAttributes(Direction.UP, Course.LINEAR, Distance.MEDIUM, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesZ_2(){
        return createMovementAttributes(Direction.DOWN, Course.LINEAR, Distance.SMALL, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesZ_3(){
        return createMovementAttributes(Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE);
    }

    public MovementAttributes createDefaultMovementAttributesZ_none(){
        return createMovementAttributes(Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE);
    }

    public BodyPartMovement createDefaultBodyPartMovementXY(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_none();
        return createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED);
    }

    public BodyPartMovement createDefaultBodyPartMovementXY_2(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_2();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_none();
        return createBodyPartMovement(BodyPart.LEFT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.ON_BALL);
    }

    public BodyPartMovement createDefaultBodyPartMovementXY_3(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_3();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_none();
        return createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.ON_WHOLE);
    }

    public BodyPartMovement createDefaultBodyPartMovementZ(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_none();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ();
        return createBodyPartMovement(BodyPart.RIGHT_HAND, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED);
    }

    public BodyPartMovement createDefaultBodyPartMovementZ_2(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_none();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_2();
        return createBodyPartMovement(BodyPart.LEFT_HAND, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED);
    }

    public BodyPartMovement createDefaultBodyPartMovementZ_3(){
        MovementAttributes movementAttributesXY = createDefaultMovementAttributesXY_none();
        MovementAttributes movementAttributesZ = createDefaultMovementAttributesZ_3();
        return createBodyPartMovement(BodyPart.RIGHT_HAND, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED);
    }

    public BodyPartMovement createBodyPartMovement(BodyPart bodyPart, MovementAttributes movementAttributesXY, MovementAttributes movementAttributesZ, WeightOnFloor weightOnFloor){
        return ModelCreator.createBodyPartMovement(bodyPart, movementAttributesXY, movementAttributesZ, weightOnFloor);
    }

    public MovementAttributes createMovementAttributes(Direction direction, Course course, Distance distance, Rotation rotation){
        return ModelCreator.createMovementAttributes(direction, course, distance, rotation);
    }

    public Dance createDefaultDance() {
        File dmdFilesFolder = new File(getClass().getResource("/definitions").getFile());
        DanceMoveDefinitions danceMoveDefinitions = ModelCreator.createDanceMoveDefinitions(dmdFilesFolder);

        Dance dance = ModelCreator.createDance("Shout Shout", 2, 32, 32, "4/4",
                "Shout Shout", "Yvonne Zielonka", 2013,
                "Shout Shout (Knock Yourself Out)", "Rocky Sharpe & The Replays", 2013);

        dance.getChoreographyMetaInfo().getMediaReferences().add(new MediaRef(MediaService.YOUTUBE, MediaType.VIDEO, "https://www.youtube.com/watch?v=rouN3dS0A60"));
        dance.getMusicMetaInfo().getMediaReferences().add(new MediaRef(MediaService.AMAZON_MUSIC, MediaType.MUSIC,
                "https://music.amazon.de/albums/B00AVH7D0M?trackAsin=B00AVH7H2Q&amp;ref=dm_sh_Ez04ftdT9VtzX7rxs97sOMqlH"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("HeelHeelRightWithHands"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("BehindSideCrossLeftDirection"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("HeelHeelLeftWithHands"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("BehindSideCrossRightDirection"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("CharlestonStepArcStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("ShuffleForwardStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("MamboForwardStartWithLF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("RunBackThreeStepsStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("CoasterStepStartWithLF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("StepTurnQuarterLeftStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("StepTurnQuarterLeftStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("JazzBoxStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("HeelToeHeelSwivelsRightAndLeft"));
        return dance;
    }

    public DanceOverview createDefaultDanceOverview(){
        return ModelCreator.createDanceOverview(createDefaultDance());
    }

    public BodyMovementGroupInstructionText createBodyMovementGroupInstructionText(BodyMovementGroup bodyMovementGroup, Messages messages){
        return ModelCreator.createBodyMovementGroupInstructionText(bodyMovementGroup, messages);
    }

    public BodyMovementInstructionText createBodyMovementInstructionText(BodyMovement bodyMovement, Messages messages){
        return ModelCreator.createBodyMovementInstructionText(bodyMovement, messages);
    }

    public BodyPartMovementInstructionText createBodyPartMovementInstructionText(BodyPartMovement bodyPartMovement, Messages messages){
        return ModelCreator.createBodyPartMovementInstructionText(bodyPartMovement, messages);
    }
}