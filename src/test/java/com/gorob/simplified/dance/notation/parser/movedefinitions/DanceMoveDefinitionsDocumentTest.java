package com.gorob.simplified.dance.notation.parser.movedefinitions;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.model.IBodyMovement;
import com.gorob.simplified.dance.notation.model.IBodyPartMovement;
import com.gorob.simplified.dance.notation.model.IDanceMoveDefinition;
import com.gorob.simplified.dance.notation.model.IDanceMoveVariantDefintion;
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

        List<IDanceMoveDefinition> danceMoveDefinitions = document.getDanceMoveDefinitions();
        assertEquals(1, danceMoveDefinitions.size());

        IDanceMoveDefinition danceMoveDefinition1 = danceMoveDefinitions.get(0);
        assertEquals("HeelHeel", danceMoveDefinition1.getId());
        assertEquals("Heel, Heel", danceMoveDefinition1.getDefaultName());

        assertEquals(2, danceMoveDefinition1.getDanceMoveVariantDefinitions().size());

        IDanceMoveVariantDefintion danceMoveVariantDefintion1 = danceMoveDefinition1.getDanceMoveVariantDefinitions().get(0);
        assertEquals("HeelHeelLeftWithHands", danceMoveVariantDefintion1.getId());
        assertEquals("Heel, Heel (LF) with Hands", danceMoveVariantDefintion1.getDefaultName());

        List<IBodyMovement> bodyMovementsForCount = danceMoveVariantDefintion1.getBodyMovementsForCount(1);
        assertEquals(2, bodyMovementsForCount.size());

        IBodyMovement bodyMovement = bodyMovementsForCount.get(0);
        assertEquals(1, bodyMovement.getCountNr());
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.LEFT_FOOT,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.SMALL, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.TAP_HEEL);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.LARGE, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.LARGE, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovement = bodyMovementsForCount.get(1);
        assertEquals(1, bodyMovement.getCountNr());
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


        bodyMovementsForCount = danceMoveVariantDefintion1.getBodyMovementsForCount(2);
        assertEquals(2, bodyMovementsForCount.size());

        bodyMovement = bodyMovementsForCount.get(0);
        assertEquals(2, bodyMovement.getCountNr());
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.LEFT_FOOT,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.SMALL, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.TAP_HEEL);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.LARGE, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.LEFT_FORWARD, Course.LINEAR, Distance.LARGE, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovement = bodyMovementsForCount.get(1);
        assertEquals(2, bodyMovement.getCountNr());
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



        IDanceMoveVariantDefintion danceMoveVariantDefintion2 = danceMoveDefinition1.getDanceMoveVariantDefinitions().get(1);
        assertEquals("HeelHeelRightWithHands", danceMoveVariantDefintion2.getId());
        assertEquals("Heel, Heel (RF) with Hands", danceMoveVariantDefintion2.getDefaultName());

        bodyMovementsForCount = danceMoveVariantDefintion2.getBodyMovementsForCount(1);
        assertEquals(2, bodyMovementsForCount.size());

        bodyMovement = bodyMovementsForCount.get(0);
        assertEquals(1, bodyMovement.getCountNr());
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.RIGHT_FOOT,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.SMALL, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.TAP_HEEL);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.LARGE, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.LARGE, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovement = bodyMovementsForCount.get(1);
        assertEquals(1, bodyMovement.getCountNr());
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


        bodyMovementsForCount = danceMoveVariantDefintion2.getBodyMovementsForCount(2);
        assertEquals(2, bodyMovementsForCount.size());

        bodyMovement = bodyMovementsForCount.get(0);
        assertEquals(2, bodyMovement.getCountNr());
        assertEquals(3, bodyMovement.getBodyPartMovements().size());
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(0), BodyPart.RIGHT_FOOT,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.SMALL, Rotation.NONE,
                Direction.NONE, Course.NONE, Distance.NONE, Rotation.NONE, WeightOnFloor.TAP_HEEL);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(1), BodyPart.LEFT_HAND,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.LARGE, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);
        assertBodyPartMovement(bodyMovement.getBodyPartMovements().get(2), BodyPart.RIGHT_HAND,
                Direction.RIGHT_FORWARD, Course.LINEAR, Distance.LARGE, Rotation.NONE,
                Direction.UP, Course.LINEAR, Distance.LARGE, Rotation.NONE, WeightOnFloor.NONE);

        bodyMovement = bodyMovementsForCount.get(1);
        assertEquals(2, bodyMovement.getCountNr());
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

    private void assertBodyPartMovement(IBodyPartMovement bodyPartMovement, BodyPart expectedBodyPart,
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