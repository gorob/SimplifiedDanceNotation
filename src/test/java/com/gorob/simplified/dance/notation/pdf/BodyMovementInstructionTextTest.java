package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyPartMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.MovementAttributes;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyMovementInstructionTextTest extends AbstractTest {
    @Test
    public void testGetBodyPartMovementInstructionTexts(){
        Messages messages = getTmc().createMessagesEnglish();
        BodyMovementInstructionText instructionText = getTmc().createBodyMovementInstructionText(getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY(), getTmc().createDefaultBodyPartMovementXY_2()), "1", messages);
        assertEquals(2, instructionText.getBodyPartMovementInstructionTexts().size());
        assertEquals("RF step forward (at the end raised foot)", instructionText.getBodyPartMovementInstructionTexts().get(0).getInstructionText());
        assertEquals("LF 1/4 turn left (at the end weight on ball)", instructionText.getBodyPartMovementInstructionTexts().get(1).getInstructionText());
    }

    @Test
    public void testText_allBodyPartMovementsDifferent(){
        Messages messages = getTmc().createMessagesEnglish();
        BodyMovementInstructionText instructionText = getTmc().createBodyMovementInstructionText(getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY(), getTmc().createDefaultBodyPartMovementXY_2()), "1", messages);

        String expectedText = "RF step forward (at the end raised foot); LF 1/4 turn left (at the end weight on ball)";
        assertEquals(expectedText, instructionText.getText());
    }

    @Test
    public void testText_bodyPartMovementsForFeetIdentical(){
        Messages messages = getTmc().createMessagesEnglish();

        BodyPartMovement bodyPartMovement1 = getTmc().createBodyPartMovement(BodyPart.LEFT_FOOT, getTmc().createMovementAttributes(Direction.FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        BodyPartMovement bodyPartMovement2 = getTmc().createBodyPartMovement(BodyPart.LEFT_HAND, getTmc().createMovementAttributes(Direction.LEFT, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        BodyPartMovement bodyPartMovement3 = getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, getTmc().createMovementAttributes(Direction.FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        BodyPartMovement bodyPartMovement4 = getTmc().createBodyPartMovement(BodyPart.RIGHT_HAND, getTmc().createMovementAttributes(Direction.LEFT, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        BodyMovementInstructionText instructionText = getTmc().createBodyMovementInstructionText(getTmc().createBodyMovement(bodyPartMovement1, bodyPartMovement2, bodyPartMovement3, bodyPartMovement4), "1", messages);
        assertEquals("LF and RF step forward; LH and RH movement left", instructionText.getText());

        bodyPartMovement1 = getTmc().createBodyPartMovement(BodyPart.LEFT_HAND, getTmc().createMovementAttributes(Direction.LEFT, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        bodyPartMovement2 = getTmc().createBodyPartMovement(BodyPart.LEFT_FOOT, getTmc().createMovementAttributes(Direction.FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        bodyPartMovement3 = getTmc().createBodyPartMovement(BodyPart.RIGHT_HAND, getTmc().createMovementAttributes(Direction.LEFT, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        bodyPartMovement4 = getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, getTmc().createMovementAttributes(Direction.FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        instructionText = getTmc().createBodyMovementInstructionText(getTmc().createBodyMovement(bodyPartMovement1, bodyPartMovement2, bodyPartMovement3, bodyPartMovement4), "1", messages);
        assertEquals("LF and RF step forward; LH and RH movement left", instructionText.getText());

        bodyPartMovement1 = getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, getTmc().createMovementAttributes(Direction.FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        bodyPartMovement2 = getTmc().createBodyPartMovement(BodyPart.LEFT_HAND, getTmc().createMovementAttributes(Direction.LEFT, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        bodyPartMovement3 = getTmc().createBodyPartMovement(BodyPart.RIGHT_HAND, getTmc().createMovementAttributes(Direction.LEFT, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        bodyPartMovement4 = getTmc().createBodyPartMovement(BodyPart.LEFT_FOOT, getTmc().createMovementAttributes(Direction.FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE), getTmc().createDefaultMovementAttributesZ_none(), WeightOnFloor.NONE);
        instructionText = getTmc().createBodyMovementInstructionText(getTmc().createBodyMovement(bodyPartMovement1, bodyPartMovement2, bodyPartMovement3, bodyPartMovement4), "1", messages);
        assertEquals("LF and RF step forward; LH and RH movement left", instructionText.getText());
    }

}