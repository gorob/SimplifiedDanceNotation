package com.gorob.simplified.dance.notation.parser.movedefinitions;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.model.movedefinition.*;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DanceMoveDefinitionsDocumentTest extends AbstractTest {
    @Test
    public void testGetDanceMoveDefinitions() throws IOException {
        File dmdFile = copyToTemp("/definitions/HeelHeel.dmd");

        DanceMoveDefinitionsDocument document = new DanceMoveDefinitionsDocument(dmdFile);
        assertEquals(DanceMoveDefinitionsDocument.NODE_NAME_ROOT, document.getMyRootNodeName());

        List<DanceMoveDefinition> danceMoveDefinitions = document.getDanceMoveDefinitions();
        assertEquals(1, danceMoveDefinitions.size());

        DanceMoveDefinition danceMoveDefinition = danceMoveDefinitions.get(0);
        assertEquals("HeelHeel", danceMoveDefinition.getId());
        assertEquals("Heel, Heel", danceMoveDefinition.getDefaultName());

        assertEquals(2, danceMoveDefinition.getDanceMoveVariantDefinitions().size());

        DanceMoveVariantDefinition danceMoveVariantDefintion1 = danceMoveDefinition.getDanceMoveVariantDefinitions().get(0);
        assertEquals("HeelHeelLeftWithHands", danceMoveVariantDefintion1.getId());
        assertEquals("Heel, Heel (LF) with Hands", danceMoveVariantDefintion1.getDefaultName());

        List<BodyMovementGroup> bodyMovementGroups = danceMoveVariantDefintion1.getBodyMovementGroups();
        assertEquals(2, bodyMovementGroups.size());

        BodyMovementGroup bodyMovementGroup = bodyMovementGroups.get(0);
        assertEquals(1, bodyMovementGroup.getCounts());
        assertEquals(2, bodyMovementGroup.getBodyMovements().size());

        BodyMovement bodyMovement = bodyMovementGroup.getBodyMovements().get(0);
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.LEFT_FOOT,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.TAP_HEEL);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovement = bodyMovementGroup.getBodyMovements().get(1);
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.LEFT_FOOT,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.RAISED);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovementGroup = bodyMovementGroups.get(1);
        assertEquals(1, bodyMovementGroup.getCounts());
        assertEquals(2, bodyMovementGroup.getBodyMovements().size());

        bodyMovement = bodyMovementGroup.getBodyMovements().get(0);
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.LEFT_FOOT,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.TAP_HEEL);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovement = bodyMovementGroup.getBodyMovements().get(1);
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.LEFT_FOOT,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.RAISED);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE, WeightOnFloor.NONE);


        DanceMoveVariantDefinition danceMoveVariantDefintion2 = danceMoveDefinition.getDanceMoveVariantDefinitions().get(1);
        assertEquals("HeelHeelRightWithHands", danceMoveVariantDefintion2.getId());
        assertEquals("Heel, Heel (RF) with Hands", danceMoveVariantDefintion2.getDefaultName());

        bodyMovementGroups = danceMoveVariantDefintion2.getBodyMovementGroups();
        assertEquals(2, bodyMovementGroups.size());

        bodyMovementGroup = bodyMovementGroups.get(0);
        assertEquals(1, bodyMovementGroup.getCounts());
        assertEquals(2, bodyMovementGroup.getBodyMovements().size());

        bodyMovement = bodyMovementGroup.getBodyMovements().get(0);
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.RIGHT_FOOT,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.TAP_HEEL);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovement = bodyMovementGroup.getBodyMovements().get(1);
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.RIGHT_FOOT,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.RAISED);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovementGroup = bodyMovementGroups.get(1);
        assertEquals(1, bodyMovementGroup.getCounts());
        assertEquals(2, bodyMovementGroup.getBodyMovements().size());

        bodyMovement = bodyMovementGroup.getBodyMovements().get(0);
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.RIGHT_FOOT,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.TAP_HEEL);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovement = bodyMovementGroup.getBodyMovements().get(1);
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.RIGHT_FOOT,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.RAISED);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE,
                Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE, WeightOnFloor.NONE);
    }

    private void assertBodyPartMovement(BodyPartMovement bodyPartMovement, BodyPart expectedBodyPart,
                                        Direction expectedDirectionXY, Course expectedCourseXY, Distance expectedDistanceXY, Rotation expectedRotationXY,
                                        Direction expectedDirectionZ, Course expectedCourseZ, Distance expectedDistanceZ, Rotation expectedRotationZ,
                                        WeightOnFloor expectedWeightOnFloorEnd){
        assertEquals(expectedBodyPart, bodyPartMovement.getBodyPart());
        assertEquals(expectedDirectionXY, bodyPartMovement.getMovementAttributesXY().getDirection());
        assertEquals(expectedCourseXY, bodyPartMovement.getMovementAttributesXY().getCourse());
        assertEquals(expectedDistanceXY, bodyPartMovement.getMovementAttributesXY().getDistance());
        assertEquals(expectedRotationXY, bodyPartMovement.getMovementAttributesXY().getRotation());
        assertEquals(expectedDirectionZ, bodyPartMovement.getMovementAttributesZ().getDirection());
        assertEquals(expectedCourseZ, bodyPartMovement.getMovementAttributesZ().getCourse());
        assertEquals(expectedDistanceZ, bodyPartMovement.getMovementAttributesZ().getDistance());
        assertEquals(expectedRotationZ, bodyPartMovement.getMovementAttributesZ().getRotation());
        assertEquals(expectedWeightOnFloorEnd, bodyPartMovement.getWeightOnFloorEnd());
    }
}