package com.gorob.simplified.dance.notation;

import com.gorob.simplified.dance.notation.model.ModelCreator;
import com.gorob.simplified.dance.notation.model.dance.*;
import com.gorob.simplified.dance.notation.model.movedefinition.*;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
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
}